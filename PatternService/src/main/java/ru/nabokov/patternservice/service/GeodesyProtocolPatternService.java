package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.protocol.GeodesyProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.NewGeodesyProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.UpdateGeodesyProtocolPatternDto;

public interface GeodesyProtocolPatternService {

    GeodesyProtocolPatternDto save(NewGeodesyProtocolPatternDto protocolDto);

    GeodesyProtocolPatternDto update(UpdateGeodesyProtocolPatternDto protocolDto);

    GeodesyProtocolPatternDto get(Long id);
}
