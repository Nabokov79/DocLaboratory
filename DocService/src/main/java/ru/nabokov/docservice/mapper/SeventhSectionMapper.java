package ru.nabokov.docservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.docservice.dto.NewDrawingDto;
import ru.nabokov.docservice.dto.client.pattern_servicce.DrawingDto;
import java.util.List;

@Mapper(componentModel = "spring")
public interface SeventhSectionMapper {

    List<DrawingDto> mapToDrawingDto(List<NewDrawingDto> drawings);
}
