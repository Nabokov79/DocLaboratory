package ru.nabokov.patternservice.service.section;

import ru.nabokov.patternservice.dto.section.NewPatternSectionDto;
import ru.nabokov.patternservice.dto.ReportPatternDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionDto;

public interface PatternSectionOneService {

    ReportPatternDto save(NewPatternSectionDto patternDto);

    ReportPatternDto update(UpdatePatternSectionDto patternDto);
}
