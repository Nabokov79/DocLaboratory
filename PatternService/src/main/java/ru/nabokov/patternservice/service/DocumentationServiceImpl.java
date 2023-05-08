package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.exceptions.BadRequestException;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.model.Documentation;
import ru.nabokov.patternservice.model.Subheading;
import ru.nabokov.patternservice.repository.DocumentationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocumentationServiceImpl implements DocumentationService {

    private final DocumentationRepository repository;

    @Override
    public void save(Subheading subheading, List<Documentation> documentations) {
        for (Documentation document : documentations) {
            validate(document);
            document.setSubheading(subheading);
        }
        repository.saveAll(documentations);
    }

    @Override
    public void update(List<Documentation> documentations) {
        validateIds(documentations.stream().map(Documentation::getId).toList());
        for (Documentation document : documentations) {
            validate(document);
        }
        repository.saveAll(documentations);
    }

    private void validate(Documentation document) {
        if (document.getTypeDocument() == null) {
            throw new BadRequestException("type document should not be blank");
        }
        if (!document.getTypeDocument().isBlank() && document.getTypeDocument().length() < 1) {
            throw new BadRequestException("length of the document type cannot be less than one");
        }
        if (document.getNumberDocument() != null && document.getNumberDocument().length() < 1) {
            throw new BadRequestException("length of the document number cannot be less than one");
        }
        if (document.getTitle() == null) {
            throw new BadRequestException("title document should not be blank");
        }
        if (document.getTitle().length() < 10) {
            throw new BadRequestException("length of the document title cannot be less than ten");
        }
    }

    private void validateIds(List<Long> ids) {
        Map<Long, Documentation> documentations = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(Documentation::getId, d -> d));
        if (documentations.size() != ids.size() || documentations.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(documentations.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("documentations with ids= %s not found", ids));
        }
    }
}
