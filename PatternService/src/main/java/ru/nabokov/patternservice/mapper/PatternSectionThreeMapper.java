package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.PatternSectionThreeDto;
import ru.nabokov.patternservice.dto.UpdatePatternSectionThreeDto;
import ru.nabokov.patternservice.model.PatternSectionThree;

@Mapper(componentModel = "spring")
public interface PatternSectionThreeMapper {

    PatternSectionThreeDto mapToPatternSectionThreeDto(PatternSectionThree pattern);

    PatternSectionThree mapToPatternSectionThree(UpdatePatternSectionThreeDto patternDto);
}
