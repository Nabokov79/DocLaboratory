package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.passport.CharacteristicDto;
import ru.nabokov.docservice.dto.pattern.HeaderDto;
import ru.nabokov.docservice.model.SecondSection;

import java.util.List;

public interface SecondSectionService {

    SecondSection save(HeaderDto header,  List<CharacteristicDto> characteristics);
}
