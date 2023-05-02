package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.exceptions.BadRequestException;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.model.Subheading;
import ru.nabokov.patternservice.repository.SubheadingRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubheadingServiceImpl implements SubheadingService {

    private final SubheadingRepository repository;
    private final DocumentationService documentationService;

    @Override
    public List<Subheading> saveAll(List<Subheading> subheadings) {
        for (Subheading subheading : subheadings) {
            validate(subheading);
        }
        List<Subheading> subheadingsDb = repository.saveAll(subheadings);
        documentationService.save(subheadings, subheadingsDb.stream()
                                                            .collect(Collectors.toMap(Subheading::getHeading, s -> s)));
        return repository.findAllById(subheadingsDb.stream().map(Subheading::getId).toList());
    }

    @Override
    public List<Subheading> updateAll(List<Subheading> subheadings) {
        validateIds(subheadings.stream().map(Subheading::getId).toList());
        for (Subheading subheading : subheadings) {
            validate(subheading);
            if (subheading.getDocumentations() != null && !subheading.getDocumentations().isEmpty()) {
                documentationService.update(subheading.getDocumentations());
            }
        }
        return repository.saveAll(subheadings);
    }

    private void validate(Subheading subheading) {
        if (subheading.getNumber() == null) {
            throw new BadRequestException("number subheading should not be blank");
        }
        if (subheading.getNumber() <= 0) {
            throw new BadRequestException("number subheading can only be positive");
        }
        if (subheading.getHeading() == null) {
            throw new BadRequestException("heading subheading should not be blank");
        }
        if (subheading.getHeading().length() < 1) {
            throw new BadRequestException("length of the subtitle of the title should not be less than one");
        }
        if (subheading.getText() != null && subheading.getText().length() < 1) {
            throw new BadRequestException("length of the text of the subtitle of the title cannot be less than one");
        }
    }

    private void validateIds(List<Long> ids) {
        Map<Long, Subheading> subheadings = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(Subheading::getId, subheading -> subheading));
        if (subheadings.size() != ids.size() || subheadings.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(subheadings.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("subheadings with ids= %s not found", ids));
        }
    }
}
