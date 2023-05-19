package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.section.NewPatternSectionThreeDto;
import ru.nabokov.patternservice.dto.section.PatternSectionThreeDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionThreeDto;

public interface PatternSectionThreeService {

    PatternSectionThreeDto save(NewPatternSectionThreeDto patternDto);

    PatternSectionThreeDto update(UpdatePatternSectionThreeDto patternDto);

    PatternSectionThreeDto get(Long patId);
}
