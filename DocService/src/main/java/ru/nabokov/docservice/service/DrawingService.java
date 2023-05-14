package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.pattern.DrawingDto;
import ru.nabokov.docservice.model.Drawing;
import ru.nabokov.docservice.model.SeventhSection;

import java.util.List;

public interface DrawingService {

    List<Drawing> save(SeventhSection section, List<DrawingDto> drawingsDto);
}
