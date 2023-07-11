package ru.nabokov.passportservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.passportservice.dto.belt.NewBeltDto;
import ru.nabokov.passportservice.dto.belt.UpdateBeltDto;
import ru.nabokov.passportservice.exceptions.NotFoundException;
import ru.nabokov.passportservice.mapper.BeltMapper;
import ru.nabokov.passportservice.model.Belt;
import ru.nabokov.passportservice.dto.belt.BeltDto;
import ru.nabokov.passportservice.repository.BeltRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BeltServiceImpl implements BeltService {

    private final BeltRepository repository;
    private final BeltMapper mapper;

    @Override
    public List<BeltDto> save(List<NewBeltDto> beltsDto) {
        return mapper.mapToBeltsDto(repository.saveAll(mapper.mapToNewBelts(beltsDto)));
    }

    @Override
    public List<BeltDto> update(List<UpdateBeltDto> beltsDto) {
        validateIds(beltsDto.stream().map(UpdateBeltDto::getId).toList());
        return mapper.mapToBeltsDto(repository.saveAll(mapper.mapToUpdateBelts(beltsDto)));
    }

    @Override
    public List<BeltDto> getAll(Integer number) {
        if (number != null) {
            return mapper.mapToBeltsDto(repository.findAllByNumber(number));
        } else {
           return mapper.mapToBeltsDto(repository.findAll());
        }
    }

    @Override
    public List<Belt> getAllById(List<Long> ids) {
        validateIds(ids);
        return repository.findAllById(ids);
    }

    private void validateIds(List<Long> ids) {
        Map<Long, Belt> belts = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(Belt::getId, b -> b));
        if (belts.size() != ids.size() || belts.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(belts.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("belts with ids= %s not found", ids));
        }
    }
}
