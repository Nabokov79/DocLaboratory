package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.ReportPatternDto;
import ru.nabokov.patternservice.model.*;

public interface ReportPatternService {

    ReportPatternDto addTitlePattern(Long typeId, TitlePattern titlePattern);

    ReportPattern get(Long id);

    ReportPatternDto save(ReportPattern pattern);

    ReportPatternDto update(ReportPattern pattern);
}
