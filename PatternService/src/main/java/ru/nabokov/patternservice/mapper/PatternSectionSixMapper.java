package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.PatternSectionSixDto;
import ru.nabokov.patternservice.dto.UpdatePatternSectionSixDto;
import ru.nabokov.patternservice.model.PatternSectionSix;

@Mapper(componentModel = "spring")
public interface PatternSectionSixMapper {

    PatternSectionSixDto mapToPatternSectionSixDto(PatternSectionSix pattern);

    PatternSectionSix mapToPatternSectionSix(UpdatePatternSectionSixDto patternDto);
}
