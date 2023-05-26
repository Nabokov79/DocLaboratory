package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.protocol.NewProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.UpdateProtocolPatternDto;
import ru.nabokov.patternservice.model.UltrasonicProtocolPattern;

@Mapper(componentModel = "spring")
public interface UltrasonicProtocolPatternMapper {

    UltrasonicProtocolPattern mapToNewUltrasonicProtocolPattern(NewProtocolPatternDto patternDto);

    UltrasonicProtocolPattern mapToUpdateUltrasonicProtocolPattern(UpdateProtocolPatternDto patternDto);
}
