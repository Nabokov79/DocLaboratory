package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.NewDrawingDto;
import ru.nabokov.docservice.dto.client.pattern_servicce.HeaderDto;
import ru.nabokov.docservice.model.seventhSection.SeventhSection;

import java.util.List;

public interface SeventhSectionService {

    SeventhSection save(HeaderDto headerDto, List<NewDrawingDto> drawings);
}
