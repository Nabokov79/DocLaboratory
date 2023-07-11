package ru.nabokov.passportservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.passportservice.dto.standardSizePipeDto.NewStandardSizePipeDto;
import ru.nabokov.passportservice.dto.standardSizePipeDto.StandardSizePipeDto;
import ru.nabokov.passportservice.dto.standardSizePipeDto.UpdateStandardSizePipeDto;
import ru.nabokov.passportservice.exceptions.NotFoundException;
import ru.nabokov.passportservice.mapper.StandardSizePipeMapper;
import ru.nabokov.passportservice.model.StandardSizePipe;
import ru.nabokov.passportservice.repository.StandardSizePipeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StandardSizePipeServiceImpl implements StandardSizePipeService {

    private final StandardSizePipeRepository repository;
    private final StandardSizePipeMapper mapper;

    @Override
    public List<StandardSizePipeDto> save(List<NewStandardSizePipeDto> standardSizePipeDto) {
        return mapper.mapToStandardSizePipeDto(repository.saveAll(mapper.mapToNewStandardSizePipe(standardSizePipeDto)));
    }

    @Override
    public List<StandardSizePipeDto> update(List<UpdateStandardSizePipeDto> standardSizePipeDto) {
        validateIds(standardSizePipeDto.stream().map(UpdateStandardSizePipeDto::getId).toList());
        return mapper.mapToStandardSizePipeDto(repository.saveAll(mapper.mapToUpdateStandardSizePipe(standardSizePipeDto)));
    }

    @Override
    public List<StandardSizePipeDto> getAll() {
        return mapper.mapToStandardSizePipeDto(repository.findAll());
    }

    private void validateIds(List<Long> ids) {
        Map<Long, StandardSizePipe> standardSizePipe = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(StandardSizePipe::getId, d -> d));
        if (standardSizePipe.size() != ids.size() || standardSizePipe.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(standardSizePipe.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("standard size pipe with ids= %s not found", ids));
        }
    }
}
