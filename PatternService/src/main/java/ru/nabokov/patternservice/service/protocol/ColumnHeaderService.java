package ru.nabokov.patternservice.service.protocol;

import ru.nabokov.patternservice.dto.columnHeader.NewColumnHeaderDto;
import ru.nabokov.patternservice.dto.columnHeader.UpdateColumnHeaderDto;
import ru.nabokov.patternservice.model.ColumnHeader;
import java.util.List;

public interface ColumnHeaderService {

    List<ColumnHeader> save(List<NewColumnHeaderDto> columnHeadersDto);

    List<ColumnHeader> update(List<UpdateColumnHeaderDto> columnHeadersDto);
}
