package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.drawing.NewDrawingDto;
import ru.nabokov.patternservice.dto.drawing.UpdateDrawingDto;
import ru.nabokov.patternservice.model.Drawing;
import ru.nabokov.patternservice.model.PatternSectionSeven;
import java.util.List;

public interface DrawingService {

    List<Drawing> save(PatternSectionSeven section, List<NewDrawingDto> drawingsDto);

    List<Drawing> update(PatternSectionSeven section, List<UpdateDrawingDto> drawingsDto);
}
