package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.model.Header;

public interface HeaderService {

    Header save(Header header);

    Header update(Header header);
}
