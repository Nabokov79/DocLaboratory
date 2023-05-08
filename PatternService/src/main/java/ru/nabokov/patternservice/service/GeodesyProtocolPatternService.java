package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.GeodesyProtocolPatternDto;
import ru.nabokov.patternservice.dto.NewGeodesyProtocolPatternDto;
import ru.nabokov.patternservice.dto.UpdateGeodesyProtocolPatternDto;

public interface GeodesyProtocolPatternService {

    GeodesyProtocolPatternDto save(NewGeodesyProtocolPatternDto protocolDto);

    GeodesyProtocolPatternDto update(UpdateGeodesyProtocolPatternDto protocolDto);

    GeodesyProtocolPatternDto get(Long id);
}
