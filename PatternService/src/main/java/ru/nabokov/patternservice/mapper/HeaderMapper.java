package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.header.HeaderDto;
import ru.nabokov.patternservice.dto.header.NewHeaderDto;
import ru.nabokov.patternservice.dto.header.UpdateHeaderDto;
import ru.nabokov.patternservice.model.Header;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HeaderMapper {

    Header mapToNewHeader(NewHeaderDto headerDto);

    Header mapToUpdateHeader(UpdateHeaderDto headerDto);

    List<HeaderDto> mapToHeadersDto(List<Header> header);
}
