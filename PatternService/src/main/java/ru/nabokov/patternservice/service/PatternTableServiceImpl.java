package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.exceptions.BadRequestException;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.model.Element;
import ru.nabokov.patternservice.model.PatternTable;
import ru.nabokov.patternservice.model.PipelineTable;
import ru.nabokov.patternservice.repository.PatternTableRepository;

@Service
@RequiredArgsConstructor
public class PatternTableServiceImpl implements PatternTableService {

    private final PatternTableRepository repository;
    private final ColumnHeaderService columnHeaderService;
    private final CombinedColumnsService combinedColumnsService;
    private final ElementService elementService;
    private final PipelineTableService pipelineTableService;

    @Override
    public PatternTable save(PatternTable table) {
        validate(table);
        table.setColumnHeaders(columnHeaderService.save(table.getColumnHeaders()));
        if (table.getCombinedColumn() != null) {
            table.setCombinedColumn(combinedColumnsService.save(table.getCombinedColumn()));
        }
        PatternTable tableDb = repository.save(table);
        if (table.getElements() != null) {
            for (Element element : table.getElements()) {
                element.setPatternTable(tableDb);
            }
            elementService.save(table.getElements());
        }
        if (table.getPipelineTables() != null) {
            for (PipelineTable pipelineTable : table.getPipelineTables()) {
                pipelineTable.setPatternTable(tableDb);
            }
            pipelineTableService.save(table.getPipelineTables());
        }
        return tableDb;
    }

    @Override
    public PatternTable update(PatternTable table) {
        if (!repository.existsById(table.getId())) {
            throw new NotFoundException(String.format("pattern table with id=%s not found for update", table.getId()));
        }
        validate(table);
        table.setColumnHeaders(columnHeaderService.update(table.getColumnHeaders()));
        table.setCombinedColumn(combinedColumnsService.update(table.getCombinedColumn()));
        PatternTable tableDb = repository.save(table);
        if (table.getElements() != null) {
            for (Element element : table.getElements()) {
                element.setPatternTable(tableDb);
            }
            elementService.update(table.getElements());
        }
        if (table.getPipelineTables() != null) {
            for (PipelineTable pipelineTable : table.getPipelineTables()) {
                pipelineTable.setPatternTable(tableDb);
            }
            pipelineTableService.update(table.getPipelineTables());
        }
        return tableDb;
    }

    private void validate(PatternTable table) {
        if (table.getColumnHeaders() == null || table.getColumnHeaders().isEmpty()) {
            throw new BadRequestException("table column headers cannot be blank");
        }
    }
}
