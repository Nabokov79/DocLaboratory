package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.protocol.GeodesyProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.NewGeodesyProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.UpdateGeodesyProtocolPatternDto;
import ru.nabokov.patternservice.model.GeodesyProtocolPattern;

@Mapper(componentModel = "spring")
public interface GeodesyProtocolMapper {

    GeodesyProtocolPattern mapToNewGeodesyProtocolPattern(NewGeodesyProtocolPatternDto patternDto);

    GeodesyProtocolPattern mapToUpdateGeodesyProtocolPattern(UpdateGeodesyProtocolPatternDto patternDto);

    GeodesyProtocolPatternDto mapToGeodesyProtocolPattern(GeodesyProtocolPattern pattern);
}
