package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.NewPatternSectionTwoDto;
import ru.nabokov.patternservice.dto.PatternSectionTwoDto;
import ru.nabokov.patternservice.dto.UpdatePatternSectionTwoDto;

public interface PatternSectionTwoService {

    PatternSectionTwoDto save(NewPatternSectionTwoDto patternDto);

    PatternSectionTwoDto update(UpdatePatternSectionTwoDto patternDto);

    PatternSectionTwoDto get(Long patId);
}
