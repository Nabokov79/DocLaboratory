package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.NewPatternSectionThreeDto;
import ru.nabokov.patternservice.dto.PatternSectionThreeDto;
import ru.nabokov.patternservice.dto.UpdatePatternSectionThreeDto;

public interface PatternSectionThreeService {

    PatternSectionThreeDto save(NewPatternSectionThreeDto patternDto);

    PatternSectionThreeDto update(UpdatePatternSectionThreeDto patternDto);

    PatternSectionThreeDto get(Long patId);
}
