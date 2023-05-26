package ru.nabokov.patternservice.service.section;

import ru.nabokov.patternservice.dto.section.NewPatternSectionDto;
import ru.nabokov.patternservice.dto.ReportPatternDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionDto;
import ru.nabokov.patternservice.model.PatternSectionFour;

public interface PatternSectionFourService {

    ReportPatternDto save(NewPatternSectionDto patternDto);

    ReportPatternDto update(UpdatePatternSectionDto patternDto);

    PatternSectionFour get(Long id);

    ReportPatternDto addProtocol(Long patternId, PatternSectionFour section);
}
