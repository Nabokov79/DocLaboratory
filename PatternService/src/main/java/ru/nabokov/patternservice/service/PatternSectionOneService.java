package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.NewPatternSectionOneDto;
import ru.nabokov.patternservice.dto.PatternSectionOneDto;
import ru.nabokov.patternservice.dto.UpdatePatternSectionOneDto;

public interface PatternSectionOneService {

    PatternSectionOneDto save(NewPatternSectionOneDto patternDto);

    PatternSectionOneDto update(UpdatePatternSectionOneDto patternDto);

    PatternSectionOneDto get(Long patId);
}
