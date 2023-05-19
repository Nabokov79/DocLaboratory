package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.client.pattern.DrawingDto;
import ru.nabokov.docservice.model.seventhSection.Drawing;
import ru.nabokov.docservice.model.seventhSection.SeventhSection;

import java.util.List;

public interface DrawingService {

    List<Drawing> save(SeventhSection section, List<DrawingDto> drawingsDto);
}
