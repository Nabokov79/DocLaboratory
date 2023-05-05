package ru.nabokov.docservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.docservice.dto.SubheadingDto;
import ru.nabokov.docservice.model.DataFirstSection;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SectionMapper {

    List<DataFirstSection> mapToDataFirstSection(List<SubheadingDto> subheadings);
}
