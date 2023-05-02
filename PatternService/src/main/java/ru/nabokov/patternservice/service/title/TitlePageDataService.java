package ru.nabokov.patternservice.service.title;

import ru.nabokov.patternservice.model.TitlePageData;

public interface TitlePageDataService {

    TitlePageData save();

    TitlePageData get(Long id);
}
