package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.model.PipelineTable;
import java.util.List;

public interface PipelineTableService {

    List<PipelineTable> save(List<PipelineTable> pipelineTables);

    List<PipelineTable> update(List<PipelineTable> pipelineTables);
}
