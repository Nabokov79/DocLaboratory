package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.NewPatternSectionSevenDto;
import ru.nabokov.patternservice.dto.PatternSectionSevenDto;
import ru.nabokov.patternservice.dto.UpdatePatternSectionSevenDto;
import ru.nabokov.patternservice.model.PatternSectionSeven;

@Mapper(componentModel = "spring")
public interface PatternSectionSevenMapper {

    PatternSectionSevenDto mapToPatternSectionSevenDto(PatternSectionSeven pattern);

    PatternSectionSeven mapToUpdatePatternSectionSeven(UpdatePatternSectionSevenDto patternDto);

    PatternSectionSeven mapToNewPatternSectionSeven(NewPatternSectionSevenDto patternDto);
}
