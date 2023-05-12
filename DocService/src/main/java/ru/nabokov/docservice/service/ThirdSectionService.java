package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.passport.PassportDto;
import ru.nabokov.docservice.dto.pattern.PatternSectionThreeDto;
import ru.nabokov.docservice.model.ThirdSection;

public interface ThirdSectionService {

    ThirdSection save(PatternSectionThreeDto patternSectionThree, PassportDto passport);
}
