package ru.nabokov.docservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.docservice.dto.NewDrawingDto;
import ru.nabokov.docservice.dto.SectionHeaderDto;
import ru.nabokov.docservice.dto.SeventhSectionDto;
import ru.nabokov.docservice.dto.pattern.DrawingDto;
import ru.nabokov.docservice.dto.pattern.HeaderDto;
import ru.nabokov.docservice.model.SeventhSection;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SeventhSectionMapper {

    HeaderDto mapToHeaderDto(SectionHeaderDto headerDto);

    List<DrawingDto> mapToDrawingDto(List<NewDrawingDto> drawings);

    SeventhSectionDto mapToSeventhSectionDto(SeventhSection section);
}
