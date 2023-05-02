package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.NewPatternSectionFiveDto;
import ru.nabokov.patternservice.dto.PatternSectionFiveDto;
import ru.nabokov.patternservice.dto.UpdatePatternSectionFiveDto;

public interface PatternSectionFiveService {

    PatternSectionFiveDto save(NewPatternSectionFiveDto patternDto);

    PatternSectionFiveDto update(UpdatePatternSectionFiveDto patternDto);

    PatternSectionFiveDto get(Long patId);
}
