package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.ReportPatternDto;
import ru.nabokov.patternservice.dto.ShortReportPatternDto;
import ru.nabokov.patternservice.model.TitlePattern;
import java.util.List;

public interface ReportPatternService {

    void save(Long typeId, TitlePattern titlePattern);

    ReportPatternDto get(Long patId);

    List<ShortReportPatternDto> getAll();

    void delete(Long patId);
}
