package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.protocol.NewProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.UpdateProtocolPatternDto;
import ru.nabokov.patternservice.model.GeodesyProtocolPattern;

@Mapper(componentModel = "spring")
public interface GeodesyProtocolMapper {

    GeodesyProtocolPattern mapToNewGeodesyProtocolPattern(NewProtocolPatternDto patternDto);

    GeodesyProtocolPattern mapToUpdateGeodesyProtocolPattern(UpdateProtocolPatternDto patternDto);
}
