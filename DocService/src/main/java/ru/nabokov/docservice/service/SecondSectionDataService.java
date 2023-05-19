package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.client.passport.CharacteristicDto;
import ru.nabokov.docservice.model.SecondSection;
import ru.nabokov.docservice.model.SecondSectionData;

import java.util.List;

public interface SecondSectionDataService {

    List<SecondSectionData> save(SecondSection section, List<CharacteristicDto> characteristics);
}
