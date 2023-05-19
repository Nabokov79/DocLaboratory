package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.section.PatternSectionOneDto;
import ru.nabokov.patternservice.dto.section.UpdatePatternSectionOneDto;
import ru.nabokov.patternservice.model.PatternSectionOne;

@Mapper(componentModel = "spring")
public interface PatternSectionOneMapper {

    PatternSectionOneDto mapToPatternSectionOneDto(PatternSectionOne pattern);

    PatternSectionOne mapToPatternSectionOne(UpdatePatternSectionOneDto patternDto);
}
