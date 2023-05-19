package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.section.NewPatternSectionFiveDto;
import ru.nabokov.patternservice.dto.section.PatternSectionFiveDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionFiveDto;
import ru.nabokov.patternservice.model.PatternSectionFive;

@Mapper(componentModel = "spring")
public interface PatternSectionFiveMapper {

    PatternSectionFiveDto mapToPatternSectionFiveDto(PatternSectionFive pattern);

    PatternSectionFive mapToUpdatePatternSectionFive(UpdatePatternSectionFiveDto patternDto);

    PatternSectionFive mapToNewPatternSectionFive(NewPatternSectionFiveDto patternDto);
}
