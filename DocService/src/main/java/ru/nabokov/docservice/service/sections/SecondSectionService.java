package ru.nabokov.docservice.service.sections;

import ru.nabokov.docservice.dto.client.passport_service.CharacteristicDto;
import ru.nabokov.docservice.dto.client.pattern_servicce.PatternSectionTwoDto;
import ru.nabokov.docservice.model.SecondSection;

import java.util.List;

public interface SecondSectionService {

    SecondSection save(PatternSectionTwoDto pattern, List<CharacteristicDto> characteristics);
}
