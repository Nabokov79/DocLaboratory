package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.NewPatternSectionFourDto;
import ru.nabokov.patternservice.dto.PatternSectionFourDto;
import ru.nabokov.patternservice.dto.UpdatePatternSectionFourDto;

public interface PatternSectionFourService {

    PatternSectionFourDto save(NewPatternSectionFourDto patternDto);

    PatternSectionFourDto update(UpdatePatternSectionFourDto patternDto);

    PatternSectionFourDto get(Long patId);
}
