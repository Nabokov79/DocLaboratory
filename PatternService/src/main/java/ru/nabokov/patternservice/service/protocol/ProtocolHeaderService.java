package ru.nabokov.patternservice.service.protocol;

import ru.nabokov.patternservice.dto.protocolHeader.NewProtocolHeaderDto;
import ru.nabokov.patternservice.dto.protocolHeader.UpdateProtocolHeaderDto;
import ru.nabokov.patternservice.model.ProtocolHeader;

public interface ProtocolHeaderService {

    ProtocolHeader save(NewProtocolHeaderDto headerDto);

    ProtocolHeader update(UpdateProtocolHeaderDto headerDto);
}
