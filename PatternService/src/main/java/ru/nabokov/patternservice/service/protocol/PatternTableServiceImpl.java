package ru.nabokov.patternservice.service.protocol;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.table.NewPatternTableDto;
import ru.nabokov.patternservice.dto.table.UpdatePatternTableDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.PatternTableMapper;
import ru.nabokov.patternservice.model.PatternTable;
import ru.nabokov.patternservice.repository.PatternTableRepository;

@Service
@RequiredArgsConstructor
public class PatternTableServiceImpl implements PatternTableService {

    private final PatternTableRepository repository;
    private final PatternTableMapper mapper;
    private final ColumnHeaderService columnHeaderService;
    private final CombinedColumnsService combinedColumnsService;

    @Override
    public PatternTable save(NewPatternTableDto tableDto) {
        PatternTable table = mapper.mapToNewPatternTable(tableDto);
        table.setColumnHeaders(columnHeaderService.save(tableDto.getColumnHeaders()));
        if (table.getCombinedColumn() != null) {
            table.setCombinedColumn(combinedColumnsService.save(tableDto.getCombinedColumn()));
        }
        return repository.save(table);
    }

    @Override
    public PatternTable update(UpdatePatternTableDto tableDto) {
        if (!repository.existsById(tableDto.getId())) {
          throw new NotFoundException(String.format("pattern table with id=%s not found for update", tableDto.getId()));
        }
        PatternTable table = mapper.mapToUpdatePatternTable(tableDto);
        table.setColumnHeaders(columnHeaderService.update(tableDto.getColumnHeaders()));
        table.setCombinedColumn(combinedColumnsService.update(tableDto.getCombinedColumn()));
        return repository.save(table);
    }
}
