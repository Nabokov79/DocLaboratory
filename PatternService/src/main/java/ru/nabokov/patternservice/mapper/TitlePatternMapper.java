package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.NewTitlePageDataDto;
import ru.nabokov.patternservice.dto.TitlePatternDto;
import ru.nabokov.patternservice.model.TitlePageData;
import ru.nabokov.patternservice.model.TitlePattern;

@Mapper(componentModel = "spring")
public interface TitlePatternMapper {

    TitlePageData mapToTextCentered(NewTitlePageDataDto reportDto);

    TitlePatternDto mapToTitlePatternDto(TitlePattern report);
}
