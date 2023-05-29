package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.client.passport_service.CharacteristicDto;
import ru.nabokov.docservice.dto.client.pattern_servicce.HeaderDto;
import ru.nabokov.docservice.model.SecondSection;

import java.util.List;

public interface SecondSectionService {

    SecondSection save(HeaderDto header, List<CharacteristicDto> characteristics);
}
