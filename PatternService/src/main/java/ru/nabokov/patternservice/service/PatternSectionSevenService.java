package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.NewPatternSectionSevenDto;
import ru.nabokov.patternservice.dto.PatternSectionSevenDto;
import ru.nabokov.patternservice.dto.UpdatePatternSectionSevenDto;

public interface PatternSectionSevenService {

    PatternSectionSevenDto save(NewPatternSectionSevenDto patternDto);

   PatternSectionSevenDto update(UpdatePatternSectionSevenDto patternDto);

   PatternSectionSevenDto get(Long patId);
}
