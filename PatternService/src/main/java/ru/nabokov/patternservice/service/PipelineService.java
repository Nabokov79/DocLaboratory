package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.model.Pipeline;

public interface PipelineService {

    Pipeline save(Pipeline pipeline);

    Pipeline update(Pipeline pipeline);
}
