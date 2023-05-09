package ru.nabokov.patternservice.service.title;

import ru.nabokov.patternservice.model.TitlePageData;

public interface TextCenteredService {

    TitlePageData save(TitlePageData textCentered);

    TitlePageData update(TitlePageData textCentered);
}
