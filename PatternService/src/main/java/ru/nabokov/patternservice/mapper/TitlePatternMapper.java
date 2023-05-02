package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.NewTextCenteredDto;
import ru.nabokov.patternservice.dto.TitlePatternDto;
import ru.nabokov.patternservice.model.TextCentered;
import ru.nabokov.patternservice.model.TitlePattern;

@Mapper(componentModel = "spring")
public interface TitlePatternMapper {

    TextCentered mapToTextCentered(NewTextCenteredDto reportDto);

    TitlePatternDto mapToTitlePatternDto(TitlePattern report);
}
