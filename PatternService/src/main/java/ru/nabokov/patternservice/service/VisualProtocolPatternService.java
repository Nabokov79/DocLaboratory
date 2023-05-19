package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.protocol.NewProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.UpdateProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.VisualProtocolPatternDto;

public interface VisualProtocolPatternService {

    VisualProtocolPatternDto save(NewProtocolPatternDto protocolDto);

    VisualProtocolPatternDto update(UpdateProtocolPatternDto protocolDto);

    VisualProtocolPatternDto get(Long id);
}
