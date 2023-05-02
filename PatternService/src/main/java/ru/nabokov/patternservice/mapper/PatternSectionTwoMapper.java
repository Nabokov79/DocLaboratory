package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.PatternSectionTwoDto;
import ru.nabokov.patternservice.dto.UpdatePatternSectionTwoDto;
import ru.nabokov.patternservice.model.PatternSectionTwo;

@Mapper(componentModel = "spring")
public interface PatternSectionTwoMapper {

    PatternSectionTwoDto mapToPatternSectionTwoDto(PatternSectionTwo pattern);

    PatternSectionTwo mapToPatternSectionTwo(UpdatePatternSectionTwoDto patternDto);
}
