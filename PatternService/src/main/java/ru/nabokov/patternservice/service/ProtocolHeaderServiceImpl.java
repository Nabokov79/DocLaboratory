package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.exceptions.BadRequestException;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.model.ProtocolHeader;
import ru.nabokov.patternservice.repository.ProtocolHeaderRepository;

@Service
@RequiredArgsConstructor
public class ProtocolHeaderServiceImpl implements ProtocolHeaderService {

    private final ProtocolHeaderRepository repository;

    @Override
    public ProtocolHeader save(ProtocolHeader header) {
        validate(header);
        header.setDocument(header.getDocument().toUpperCase());
        return repository.save(header);
    }

    @Override
    public ProtocolHeader update(ProtocolHeader header) {
        if (repository.existsById(header.getId())) {
            throw new NotFoundException(
                                      String.format("Protocol header with id=%s not found for update", header.getId()));
        }
        validate(header);
        header.setDocument(header.getDocument().toUpperCase());
        return repository.save(header);
    }

    private void validate(ProtocolHeader header) {
        if (header.getNumber() == null) {
            throw new BadRequestException("number protocol header should not be blank");
        }
        if (header.getNumber() <= 0) {
            throw new BadRequestException("number protocol header can only be positive");
        }
        if (header.getDocument() == null) {
            throw new BadRequestException("document type should not be blank");
        }
        if (header.getName() == null) {
            throw new BadRequestException("document name should not be blank");
        }
        if (header.getText() == null) {
            throw new BadRequestException("text should not be blank");
        }
        if (header.getTextMeasurements() == null) {
            throw new BadRequestException("text for measurements should not be blank");
        }
    }
}
