package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.NewProtocolPatternDto;
import ru.nabokov.patternservice.dto.UpdateProtocolPatternDto;
import ru.nabokov.patternservice.dto.VisualProtocolPatternDto;

public interface VisualProtocolPatternService {

    VisualProtocolPatternDto save(NewProtocolPatternDto protocolDto);

    VisualProtocolPatternDto update(UpdateProtocolPatternDto protocolDto);

    VisualProtocolPatternDto get(Long id);
}
