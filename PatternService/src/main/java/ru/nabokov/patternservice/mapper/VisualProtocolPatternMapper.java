package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.protocol.NewProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.UpdateProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.VisualProtocolPatternDto;
import ru.nabokov.patternservice.model.VisualProtocolPattern;

@Mapper(componentModel = "spring")
public interface VisualProtocolPatternMapper {

    VisualProtocolPattern mapToNewVisualProtocolPattern(NewProtocolPatternDto patternDto);

    VisualProtocolPattern mapToUpdateVisualProtocolPattern(UpdateProtocolPatternDto patternDto);

    VisualProtocolPatternDto mapToVisualProtocolPatternDto(VisualProtocolPattern pattern);
}
