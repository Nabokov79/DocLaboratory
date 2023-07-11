package ru.nabokov.dataservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.dataservice.dto.norm.NewNormsDto;
import ru.nabokov.dataservice.dto.norm.NormsDto;
import ru.nabokov.dataservice.dto.norm.UpdateNormsDto;
import ru.nabokov.dataservice.exceptions.NotFoundException;
import ru.nabokov.dataservice.mapper.NormsMapper;
import ru.nabokov.dataservice.model.Norm;
import ru.nabokov.dataservice.repository.NormsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NormsServiceImpl implements NormsService {

    private final NormsRepository repository;
    private final NormsMapper mapper;


    @Override
    public List<NormsDto> save(List<NewNormsDto> normsDto) {
        return mapper.mapToNormsDto(repository.saveAll(mapper.mapToNewNormsDto(normsDto)));
    }

    @Override
    public List<NormsDto> update(List<UpdateNormsDto> normsDto) {
        validateIds(normsDto.stream().map(UpdateNormsDto::getId).toList());
        return mapper.mapToNormsDto(repository.saveAll(mapper.mapToUpdateNormsDto(normsDto)));
    }

    private void validateIds(List<Long> ids) {
        Map<Long, Norm> norms = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(Norm::getId, n -> n));
        if (norms.size() != ids.size() || norms.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(norms.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("Norms with ids= %s not found", ids));
        }
    }
}
