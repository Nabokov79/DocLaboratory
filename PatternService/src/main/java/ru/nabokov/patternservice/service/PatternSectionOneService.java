package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.section.NewPatternSectionOneDto;
import ru.nabokov.patternservice.dto.section.PatternSectionOneDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionOneDto;

public interface PatternSectionOneService {

    PatternSectionOneDto save(NewPatternSectionOneDto patternDto);

    PatternSectionOneDto update(UpdatePatternSectionOneDto patternDto);

    PatternSectionOneDto get(Long patId);
}
