package ru.nabokov.patternservice.service.title;

import ru.nabokov.patternservice.dto.NewTextCenteredDto;
import ru.nabokov.patternservice.dto.TitlePatternDto;
import ru.nabokov.patternservice.dto.UpdateTitlePatternDto;

public interface TitlePatternService {

    TitlePatternDto save(NewTextCenteredDto textCenteredDto);

    TitlePatternDto update(UpdateTitlePatternDto titlePatternDto);
}
