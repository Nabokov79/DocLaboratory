package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.section.NewPatternSectionSixDto;
import ru.nabokov.patternservice.dto.section.PatternSectionSixDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionSixDto;
import ru.nabokov.patternservice.model.PatternSectionSix;

@Mapper(componentModel = "spring")
public interface PatternSectionSixMapper {

    PatternSectionSixDto mapToPatternSectionSixDto(PatternSectionSix pattern);

    PatternSectionSix mapToUpdatePatternSectionSix(UpdatePatternSectionSixDto patternDto);

    PatternSectionSix mapToNewPatternSectionSix(NewPatternSectionSixDto patternDto);
}
