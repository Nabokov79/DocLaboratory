package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.columnHeader.NewColumnHeaderDto;
import ru.nabokov.patternservice.dto.columnHeader.UpdateColumnHeaderDto;
import ru.nabokov.patternservice.model.ColumnHeader;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ColumnHeaderMapper {

    List<ColumnHeader> mapToNewColumnHeader(List<NewColumnHeaderDto> columnHeaderDto);

    List<ColumnHeader> mapToUpdateColumnHeader(List<UpdateColumnHeaderDto> columnHeaderDto);
}
