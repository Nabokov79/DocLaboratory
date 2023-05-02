package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.ReportPatternDto;
import ru.nabokov.patternservice.dto.ShortReportPatternDto;
import ru.nabokov.patternservice.model.ReportPattern;

@Mapper(componentModel = "spring")
public interface ReportPatternMapper {

    ReportPatternDto mapToReportPatternDto(ReportPattern pattern);

    ShortReportPatternDto mapToShortReportPatternDto(ReportPattern pattern);
}
