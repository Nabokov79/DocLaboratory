package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.table.NewPatternTableDto;
import ru.nabokov.patternservice.dto.table.UpdatePatternTableDto;
import ru.nabokov.patternservice.model.PatternTable;

@Mapper(componentModel = "spring")
public interface PatternTableMapper {

    PatternTable mapToNewPatternTable(NewPatternTableDto tableDto);

    PatternTable mapToUpdatePatternTable(UpdatePatternTableDto tableDto);
}
