package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.protocol.NewProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.UpdateProtocolPatternDto;
import ru.nabokov.patternservice.model.HardnessProtocolPattern;

@Mapper(componentModel = "spring")
public interface HardnessProtocolMapper {

    HardnessProtocolPattern mapToNewHardnessProtocolPattern(NewProtocolPatternDto patternDto);

    HardnessProtocolPattern mapToUpdateHardnessProtocolPattern(UpdateProtocolPatternDto patternDto);
}
