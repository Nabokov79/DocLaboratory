package ru.nabokov.patternservice.service.protocol;

import ru.nabokov.patternservice.dto.ReportPatternDto;
import ru.nabokov.patternservice.dto.protocol.NewProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.UpdateProtocolPatternDto;

public interface UltrasonicProtocolPatternService {

    ReportPatternDto save(NewProtocolPatternDto protocolDto);

    ReportPatternDto update(UpdateProtocolPatternDto protocolDto);
}