package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.client.passport.PassportDto;
import ru.nabokov.docservice.dto.client.pattern.PatternSectionThreeDto;
import ru.nabokov.docservice.model.thirdSection.ThirdSection;

public interface ThirdSectionService {

    ThirdSection save(PatternSectionThreeDto patternSectionThree, PassportDto passport);
}
