package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.HardnessProtocolPatternDto;
import ru.nabokov.patternservice.dto.NewProtocolPatternDto;
import ru.nabokov.patternservice.dto.UpdateProtocolPatternDto;

public interface HardnessProtocolPatternService {

    HardnessProtocolPatternDto save(NewProtocolPatternDto protocolDto);

    HardnessProtocolPatternDto update(UpdateProtocolPatternDto protocolDto);

    HardnessProtocolPatternDto get(Long id);
}
