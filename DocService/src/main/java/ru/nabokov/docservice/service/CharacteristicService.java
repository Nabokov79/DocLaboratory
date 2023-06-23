package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.client.passport_service.CharacteristicDto;
import ru.nabokov.docservice.dto.client.pattern_servicce.ShortSubheadingDto;
import ru.nabokov.docservice.model.SecondSection;
import ru.nabokov.docservice.model.Characteristic;

import java.util.List;

public interface CharacteristicService {

    List<Characteristic> save(SecondSection section
                            , List<ShortSubheadingDto> subheadings
                            , List<CharacteristicDto> characteristics);
}
