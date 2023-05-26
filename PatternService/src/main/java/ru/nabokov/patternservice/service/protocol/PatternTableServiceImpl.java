package ru.nabokov.patternservice.service.protocol;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.table.NewPatternTableDto;
import ru.nabokov.patternservice.dto.table.UpdatePatternTableDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.PatternTableMapper;
import ru.nabokov.patternservice.model.Element;
import ru.nabokov.patternservice.model.PatternTable;
import ru.nabokov.patternservice.repository.PatternTableRepository;

@Service
@RequiredArgsConstructor
public class PatternTableServiceImpl implements PatternTableService {

    private final PatternTableRepository repository;
    private final PatternTableMapper mapper;
    private final ColumnHeaderService columnHeaderService;
    private final CombinedColumnsService combinedColumnsService;
    private final ElementService elementService;

    @Override
    public PatternTable save(NewPatternTableDto tableDto) {
        PatternTable table = mapper.mapToNewPatternTable(tableDto);
        table.setColumnHeaders(columnHeaderService.save(tableDto.getColumnHeaders()));
        if (table.getCombinedColumn() != null) {
            table.setCombinedColumn(combinedColumnsService.save(tableDto.getCombinedColumn()));
        }
        PatternTable tableDb = repository.save(table);
        if (table.getElements() != null) {
            for (Element element : table.getElements()) {
                element.setPatternTable(tableDb);
            }
            elementService.save(tableDto.getElements());
        }
        return tableDb;
    }

    @Override
    public PatternTable update(UpdatePatternTableDto tableDto) {
        if (!repository.existsById(tableDto.getId())) {
          throw new NotFoundException(String.format("pattern table with id=%s not found for update", tableDto.getId()));
        }
        PatternTable table = mapper.mapToUpdatePatternTable(tableDto);
        table.setColumnHeaders(columnHeaderService.update(tableDto.getColumnHeaders()));
        table.setCombinedColumn(combinedColumnsService.update(tableDto.getCombinedColumn()));
        PatternTable tableDb = repository.save(table);
        if (table.getElements() != null) {
            for (Element element : table.getElements()) {
                element.setPatternTable(tableDb);
            }
            elementService.update(tableDto.getElements());
        }
        return tableDb;
    }
}
