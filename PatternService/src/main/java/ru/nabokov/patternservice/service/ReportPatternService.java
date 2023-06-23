package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.ReportPatternDto;
import ru.nabokov.patternservice.dto.ShortReportPatternDto;
import ru.nabokov.patternservice.model.*;

import java.util.List;

public interface ReportPatternService {

    ReportPatternDto save(ReportPattern pattern);

    ReportPatternDto update(ReportPattern pattern);

    ReportPatternDto get(Long id);

    List<ShortReportPatternDto> getAll();
}
