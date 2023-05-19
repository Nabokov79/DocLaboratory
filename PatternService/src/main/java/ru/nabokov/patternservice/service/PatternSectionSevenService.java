package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.section.NewPatternSectionSevenDto;
import ru.nabokov.patternservice.dto.section.PatternSectionSevenDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionSevenDto;

public interface PatternSectionSevenService {

    PatternSectionSevenDto save(NewPatternSectionSevenDto patternDto);

   PatternSectionSevenDto update(UpdatePatternSectionSevenDto patternDto);

   PatternSectionSevenDto get(Long patId);
}
