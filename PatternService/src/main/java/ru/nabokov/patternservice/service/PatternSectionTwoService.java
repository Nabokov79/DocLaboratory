package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.section.NewPatternSectionTwoDto;
import ru.nabokov.patternservice.dto.section.PatternSectionTwoDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionTwoDto;

public interface PatternSectionTwoService {

    PatternSectionTwoDto save(NewPatternSectionTwoDto patternDto);

    PatternSectionTwoDto update(UpdatePatternSectionTwoDto patternDto);

    PatternSectionTwoDto get(Long patId);
}
