package ru.nabokov.patternservice.service.title;

import ru.nabokov.patternservice.dto.NewTitlePageDataDto;
import ru.nabokov.patternservice.dto.TitlePatternDto;
import ru.nabokov.patternservice.dto.UpdateTitlePatternDto;

public interface TitlePatternService {

    TitlePatternDto save(NewTitlePageDataDto textCenteredDto);

    TitlePatternDto update(UpdateTitlePatternDto titlePatternDto);
}
