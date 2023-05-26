package ru.nabokov.patternservice.service.protocol;

import ru.nabokov.patternservice.dto.table.NewPatternTableDto;
import ru.nabokov.patternservice.dto.table.UpdatePatternTableDto;
import ru.nabokov.patternservice.model.PatternTable;

public interface PatternTableService {

    PatternTable save(NewPatternTableDto tableDto);

    PatternTable update(UpdatePatternTableDto tableDto);
}
