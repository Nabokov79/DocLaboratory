package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.NewProtocolPatternDto;
import ru.nabokov.patternservice.dto.UpdateProtocolPatternDto;
import ru.nabokov.patternservice.model.UltrasonicProtocolPattern;

public interface UltrasonicProtocolPatternService {

    UltrasonicProtocolPattern save(NewProtocolPatternDto protocolDto);

    UltrasonicProtocolPattern update(UpdateProtocolPatternDto protocolDto);

    UltrasonicProtocolPattern get(Long proId);
}