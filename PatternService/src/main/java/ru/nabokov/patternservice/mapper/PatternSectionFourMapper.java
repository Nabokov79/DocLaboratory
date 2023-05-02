package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.NewPatternSectionFourDto;
import ru.nabokov.patternservice.dto.PatternSectionFourDto;
import ru.nabokov.patternservice.dto.UpdatePatternSectionFourDto;
import ru.nabokov.patternservice.model.PatternSectionFour;

@Mapper(componentModel = "spring")
public interface PatternSectionFourMapper {

    PatternSectionFourDto mapToPatternSectionFourDto(PatternSectionFour pattern);

    PatternSectionFour mapToNewPatternSectionFourDto(NewPatternSectionFourDto pattern);

    PatternSectionFour mapToUpdatePatternSectionFourDto(UpdatePatternSectionFourDto patternDto);
}
