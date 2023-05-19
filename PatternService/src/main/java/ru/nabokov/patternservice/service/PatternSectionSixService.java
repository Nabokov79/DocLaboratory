package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.section.NewPatternSectionSixDto;
import ru.nabokov.patternservice.dto.section.PatternSectionSixDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionSixDto;

public interface PatternSectionSixService {

    PatternSectionSixDto save(NewPatternSectionSixDto patternDto);

    PatternSectionSixDto update(UpdatePatternSectionSixDto patternDto);

    PatternSectionSixDto get(Long patId);
}
