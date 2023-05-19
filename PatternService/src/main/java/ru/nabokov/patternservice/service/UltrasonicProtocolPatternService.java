package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.protocol.NewProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.UpdateProtocolPatternDto;
import ru.nabokov.patternservice.model.UltrasonicProtocolPattern;

public interface UltrasonicProtocolPatternService {

    UltrasonicProtocolPattern save(NewProtocolPatternDto protocolDto);

    UltrasonicProtocolPattern update(UpdateProtocolPatternDto protocolDto);

    UltrasonicProtocolPattern get(Long id);
}