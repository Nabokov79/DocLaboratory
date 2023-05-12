package ru.nabokov.docservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.docservice.dto.pattern.ColumnHeaderDto;
import ru.nabokov.docservice.dto.pattern.SubheadingDto;
import ru.nabokov.docservice.dto.pattern.SubheadingThreeDto;
import ru.nabokov.docservice.model.ColumnHeader;
import ru.nabokov.docservice.model.DataFirstSection;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SectionMapper {

    List<DataFirstSection> mapToDataFirstSection(List<SubheadingDto> subheadings);
    List<ColumnHeader> mapToColumnHeaders(List<ColumnHeaderDto> columnHeaders);
}
