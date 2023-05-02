package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.model.Element;
import ru.nabokov.patternservice.model.Pipeline;
import ru.nabokov.patternservice.model.PipelineTable;
import ru.nabokov.patternservice.repository.PipelineTableRepository;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PipelineTableServiceImpl implements PipelineTableService {

    private final PipelineTableRepository repository;
    private final PipelineService pipelineService;
    private final ElementService elementService;

    @Override
    public List<PipelineTable> save(List<PipelineTable> pipelineTables) {
        Map<String, Pipeline> pipelines = getPipelines(pipelineTables);
        Map<String,List<Element>> elements = pipelineTables.stream()
                                       .collect(Collectors.toMap(pipelineTable -> pipelineTable.getPipeline().getName(),
                                                                                          PipelineTable::getElements ));
        for (PipelineTable pipelineTable : pipelineTables) {
            pipelineTable.setPipeline(pipelineService.save(pipelines.get(pipelineTable.getPipeline().getName())));
        }
        Map<String, PipelineTable> tables = savePipelineTable(pipelineTables);
        for (PipelineTable table : tables.values()) {
            elementService.save(getElements(table, elements.get(table.getPipeline().getName())));
        }
        return tables.values().stream().toList();
    }

    @Override
    public List<PipelineTable> update(List<PipelineTable> pipelineTables) {
        Map<String, Pipeline> pipelines = getPipelines(pipelineTables);
        Map<String,List<Element>> elements = pipelineTables.stream()
                                       .collect(Collectors.toMap(pipelineTable -> pipelineTable.getPipeline().getName(),
                                                                                          PipelineTable::getElements ));
        for (PipelineTable pipelineTable : pipelineTables) {
            pipelineTable.setPipeline(pipelineService.update(pipelines.get(pipelineTable.getPipeline().getName())));
        }
        Map<String, PipelineTable> tables = savePipelineTable(pipelineTables);
        for (PipelineTable table : tables.values()) {
            elementService.update(getElements(table, elements.get(table.getPipeline().getName())));
        }
        return tables.values().stream().toList();
    }

    private List<Element> getElements(PipelineTable table, List<Element> elements) {
        for (Element element : elements) {
            element.setPipelineTable(table);
        }
        return elements;
    }

    private Map<String, Pipeline> getPipelines(List<PipelineTable> pipelineTables) {
        return pipelineTables.stream().collect(Collectors.toMap(table -> table.getPipeline().getName(),
                                                                            PipelineTable::getPipeline));
    }

    private Map<String, PipelineTable> savePipelineTable(List<PipelineTable> pipelineTables) {
        return repository.saveAll(pipelineTables).stream()
                                                 .collect(Collectors.toMap(table -> table.getPipeline().getName(),
                                                                           pipelineTable -> pipelineTable));
    }
}
