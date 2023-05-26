package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.protocolHeader.NewProtocolHeaderDto;
import ru.nabokov.patternservice.dto.protocolHeader.UpdateProtocolHeaderDto;
import ru.nabokov.patternservice.model.ProtocolHeader;

@Mapper(componentModel = "spring")
public interface ProtocolHeaderMapper {

    ProtocolHeader mapToNewProtocolHeader(NewProtocolHeaderDto headerDto);

    ProtocolHeader mapToUpdateProtocolHeader(UpdateProtocolHeaderDto headerDto);
}
