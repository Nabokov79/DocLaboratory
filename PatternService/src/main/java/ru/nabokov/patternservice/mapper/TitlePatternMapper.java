package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.title.NewTitlePageDataDto;
import ru.nabokov.patternservice.dto.title.UpdateTitlePageDataDto;
import ru.nabokov.patternservice.model.TitlePattern;

@Mapper(componentModel = "spring")
public interface TitlePatternMapper {

    TitlePattern mapToNewTitlePageData(NewTitlePageDataDto titlePageData);

    TitlePattern mapToUpdateTitlePageData(UpdateTitlePageDataDto titlePageData);
}
