package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.header.NewHeaderDto;
import ru.nabokov.patternservice.dto.header.UpdateHeaderDto;
import ru.nabokov.patternservice.model.Header;

@Mapper(componentModel = "spring")
public interface HeaderMapper {

    Header mapToNewHeader(NewHeaderDto headerDto);

    Header mapToUpdateHeader(UpdateHeaderDto headerDto);
}
