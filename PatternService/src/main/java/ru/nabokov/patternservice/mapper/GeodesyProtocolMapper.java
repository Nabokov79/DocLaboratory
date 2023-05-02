package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.GeodesyProtocolPatternDto;
import ru.nabokov.patternservice.dto.NewGeodesyProtocolPatternDto;
import ru.nabokov.patternservice.dto.UpdateGeodesyProtocolPatternDto;
import ru.nabokov.patternservice.model.GeodesyProtocolPattern;

@Mapper(componentModel = "spring")
public interface GeodesyProtocolMapper {

    GeodesyProtocolPattern mapToNewGeodesyProtocolPattern(NewGeodesyProtocolPatternDto patternDto);

    GeodesyProtocolPattern mapToUpdateGeodesyProtocolPattern(UpdateGeodesyProtocolPatternDto patternDto);

    GeodesyProtocolPatternDto mapToGeodesyProtocolPattern(GeodesyProtocolPattern pattern);
}
