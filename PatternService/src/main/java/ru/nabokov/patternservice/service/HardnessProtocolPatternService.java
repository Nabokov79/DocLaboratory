package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.HardnessProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.NewProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.UpdateProtocolPatternDto;

public interface HardnessProtocolPatternService {

    HardnessProtocolPatternDto save(NewProtocolPatternDto protocolDto);

    HardnessProtocolPatternDto update(UpdateProtocolPatternDto protocolDto);

    HardnessProtocolPatternDto get(Long id);
}
