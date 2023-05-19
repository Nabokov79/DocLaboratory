package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.section.NewPatternSectionSevenDto;
import ru.nabokov.patternservice.dto.section.PatternSectionSevenDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionSevenDto;
import ru.nabokov.patternservice.model.PatternSectionSeven;

@Mapper(componentModel = "spring")
public interface PatternSectionSevenMapper {

    PatternSectionSevenDto mapToPatternSectionSevenDto(PatternSectionSeven pattern);

    PatternSectionSeven mapToUpdatePatternSectionSeven(UpdatePatternSectionSevenDto patternDto);

    PatternSectionSeven mapToNewPatternSectionSeven(NewPatternSectionSevenDto patternDto);
}
