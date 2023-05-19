package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.section.NewPatternSectionFiveDto;
import ru.nabokov.patternservice.dto.section.PatternSectionFiveDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionFiveDto;

public interface PatternSectionFiveService {

    PatternSectionFiveDto save(NewPatternSectionFiveDto patternDto);

    PatternSectionFiveDto update(UpdatePatternSectionFiveDto patternDto);

    PatternSectionFiveDto get(Long patId);
}
