package ru.nabokov.passportservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.passportservice.dto.bottom.NewBottomDto;
import ru.nabokov.passportservice.dto.bottom.BottomDto;
import ru.nabokov.passportservice.dto.bottom.UpdateBottomDto;
import ru.nabokov.passportservice.exceptions.NotFoundException;
import ru.nabokov.passportservice.mapper.BottomMapper;
import ru.nabokov.passportservice.model.Bottom;
import ru.nabokov.passportservice.repository.BottomRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BottomServiceImpl implements BottomService {

    private final BottomRepository repository;
    private final BottomMapper mapper;

    @Override
    public List<BottomDto> save(List<NewBottomDto> bottomsDto) {
        return mapper.mapToBottomsDto(repository.saveAll(mapper.mapToNewBottoms(bottomsDto)));
    }

    @Override
    public List<BottomDto> update(List<UpdateBottomDto> bottomsDto) {
        validateIds(bottomsDto.stream().map(UpdateBottomDto::getId).toList());
        return mapper.mapToBottomsDto(repository.saveAll(mapper.mapToUpdateBottoms(bottomsDto)));
    }

    @Override
    public List<BottomDto> getAll(String name) {
        if (name != null) {
             return mapper.mapToBottomsDto(repository.findAllByName(name));
        } else {
           return mapper.mapToBottomsDto(repository.findAll());
        }
    }

    @Override
    public List<Bottom> getAllById(List<Long> ids) {
        validateIds(ids);
        return repository.findAllById(ids);
    }

    private void validateIds(List<Long> ids) {
        Map<Long, Bottom> bottoms = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(Bottom::getId, d -> d));
        if (bottoms.size() != ids.size() || bottoms.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(bottoms.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("bottoms with ids= %s not found", ids));
        }
    }
}
