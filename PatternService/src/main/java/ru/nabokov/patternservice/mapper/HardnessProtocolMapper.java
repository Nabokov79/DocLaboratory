package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.HardnessProtocolPatternDto;
import ru.nabokov.patternservice.dto.NewProtocolPatternDto;
import ru.nabokov.patternservice.dto.UpdateProtocolPatternDto;
import ru.nabokov.patternservice.model.HardnessProtocolPattern;

@Mapper(componentModel = "spring")
public interface HardnessProtocolMapper {

    HardnessProtocolPattern mapToNewHardnessProtocolPattern(NewProtocolPatternDto patternDto);

    HardnessProtocolPattern mapToUpdateHardnessProtocolPattern(UpdateProtocolPatternDto patternDto);

    HardnessProtocolPatternDto mapFromHardnessProtocolPattern(HardnessProtocolPattern pattern);
}
