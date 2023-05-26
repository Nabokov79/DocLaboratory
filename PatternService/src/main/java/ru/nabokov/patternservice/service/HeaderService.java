package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.header.NewHeaderDto;
import ru.nabokov.patternservice.dto.header.UpdateHeaderDto;
import ru.nabokov.patternservice.model.Header;

public interface HeaderService {

    Header save(NewHeaderDto headerDto);

    Header update(UpdateHeaderDto headerDto);
}
