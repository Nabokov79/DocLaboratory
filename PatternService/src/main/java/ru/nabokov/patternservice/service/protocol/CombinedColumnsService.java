package ru.nabokov.patternservice.service.protocol;

import ru.nabokov.patternservice.dto.combinedColumns.NewCombinedColumnsDto;
import ru.nabokov.patternservice.dto.combinedColumns.UpdateCombinedColumnsDto;
import ru.nabokov.patternservice.model.CombinedColumns;

public interface CombinedColumnsService {

    CombinedColumns save(NewCombinedColumnsDto columnsDto);

    CombinedColumns update(UpdateCombinedColumnsDto columnsDto);
}
