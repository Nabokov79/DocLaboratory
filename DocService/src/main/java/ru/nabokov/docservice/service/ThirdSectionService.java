package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.client.passport_service.PassportDto;
import ru.nabokov.docservice.dto.client.pattern_servicce.PatternSectionThreeDto;
import ru.nabokov.docservice.model.thirdSection.ThirdSection;

public interface ThirdSectionService {

    ThirdSection save(PatternSectionThreeDto patternSectionThree, PassportDto passport);
}
