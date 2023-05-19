package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.client.passport.CharacteristicDto;
import ru.nabokov.docservice.dto.client.pattern.HeaderDto;
import ru.nabokov.docservice.model.SecondSection;

import java.util.List;

public interface SecondSectionService {

    SecondSection save(HeaderDto header,  List<CharacteristicDto> characteristics);
}
