package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.exceptions.BadRequestException;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.model.Pipeline;
import ru.nabokov.patternservice.repository.PipelineRepository;

@Service
@RequiredArgsConstructor
public class PipelineServiceImpl implements PipelineService {

    private final PipelineRepository repository;

    @Override
    public Pipeline save(Pipeline pipeline) {
        validate(pipeline.getName());
        return repository.save(pipeline);
    }

    @Override
    public Pipeline update(Pipeline pipeline) {
        if (!repository.existsById(pipeline.getId())) {
            throw new NotFoundException("pipeline with id=%s not found for update");
        }
        validate(pipeline.getName());
        return repository.save(pipeline);
    }

    private void validate(String name) {
        if (name == null) {
            throw new BadRequestException("pipeline name cannot be blank");
        }
    }
}
