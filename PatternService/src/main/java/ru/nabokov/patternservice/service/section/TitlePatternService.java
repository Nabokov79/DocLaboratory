package ru.nabokov.patternservice.service.section;

import ru.nabokov.patternservice.dto.title.NewTitlePageDataDto;
import ru.nabokov.patternservice.dto.ReportPatternDto;
import ru.nabokov.patternservice.dto.title.UpdateTitlePageDataDto;

public interface TitlePatternService {

    ReportPatternDto save(NewTitlePageDataDto titlePageDataDto);

    ReportPatternDto update(UpdateTitlePageDataDto titlePatternDto);
}
