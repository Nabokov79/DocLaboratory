package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.section.NewPatternSectionFourDto;
import ru.nabokov.patternservice.dto.section.PatternSectionFourDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionFourDto;

public interface PatternSectionFourService {

    PatternSectionFourDto save(NewPatternSectionFourDto patternDto);

    PatternSectionFourDto update(UpdatePatternSectionFourDto patternDto);

    PatternSectionFourDto get(Long patId);
}
