package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.NewPatternSectionSixDto;
import ru.nabokov.patternservice.dto.PatternSectionSixDto;
import ru.nabokov.patternservice.dto.UpdatePatternSectionSixDto;

public interface PatternSectionSixService {

    PatternSectionSixDto save(NewPatternSectionSixDto patternDto);

    PatternSectionSixDto update(UpdatePatternSectionSixDto patternDto);

    PatternSectionSixDto get(Long patId);
}
