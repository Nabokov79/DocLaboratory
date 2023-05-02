package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.model.ProtocolHeader;

public interface ProtocolHeaderService {

    ProtocolHeader save(ProtocolHeader header);

    ProtocolHeader update(ProtocolHeader header);
}
