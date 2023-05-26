package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.combinedColumns.NewCombinedColumnsDto;
import ru.nabokov.patternservice.dto.combinedColumns.UpdateCombinedColumnsDto;
import ru.nabokov.patternservice.model.CombinedColumns;

@Mapper(componentModel = "spring")
public interface CombinedColumnsMapper {

    CombinedColumns mapToNewCombinedColumns(NewCombinedColumnsDto columnsDto);

    CombinedColumns mapToUpdateCombinedColumns(UpdateCombinedColumnsDto columnsDto);
}
