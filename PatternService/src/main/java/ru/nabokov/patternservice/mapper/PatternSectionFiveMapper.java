package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.PatternSectionFiveDto;
import ru.nabokov.patternservice.dto.UpdatePatternSectionFiveDto;
import ru.nabokov.patternservice.model.PatternSectionFive;

@Mapper(componentModel = "spring")
public interface PatternSectionFiveMapper {

    PatternSectionFiveDto mapToPatternSectionFiveDto(PatternSectionFive pattern);

    PatternSectionFive mapToPatternSectionFive(UpdatePatternSectionFiveDto patternDto);
}
