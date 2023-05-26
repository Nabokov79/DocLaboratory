package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.drawing.NewDrawingDto;
import ru.nabokov.patternservice.dto.drawing.UpdateDrawingDto;
import ru.nabokov.patternservice.model.Drawing;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DrawingMapper {

    List<Drawing> mapToNewDrawing(List<NewDrawingDto> drawings);

    List<Drawing> mapToUpdateDrawing(List<UpdateDrawingDto> drawings);
}
