package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.model.Documentation;
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
    private final ColumnHeaderService columnHeaderService;

    @Override
    public List<Subheading> saveAll(List<Subheading> subheadings) {
        for (Subheading subheading : subheadings) {
            if (!subheading.getColumnHeaders().isEmpty()) {
                subheading.setColumnHeaders(columnHeaderService.save(subheading.getColumnHeaders()));
            }
        }
        List<Subheading> subheading = repository.saveAll(subheadings);
        Map<Double, Subheading> subheadingsDb = subheading.stream()
                                                          .filter(s -> s.getDocumentations() != null)
                                                          .collect(Collectors.toMap(Subheading::getNumber, s -> s));
        Map<Double,List<Documentation>> documentations = subheadings
                                       .stream()
                                       .filter(s -> s.getDocumentations() != null)
                                       .collect(Collectors.toMap(Subheading::getNumber, Subheading::getDocumentations));
        for (Double number : subheadings.stream().filter(s -> s.getDocumentations() != null)
                                                 .map(Subheading::getNumber)
                                                 .toList()){
            documentationService.save(subheadingsDb.get(number), documentations.get(number));
        }
        return subheading;
    }

    @Override
    public List<Subheading> updateAll(List<Subheading> subheadings) {
        validateIds(subheadings.stream().map(Subheading::getId).toList());
        for (Subheading subheading : subheadings) {
            if (!subheading.getColumnHeaders().isEmpty()) {
                subheading.setColumnHeaders(columnHeaderService.update(subheading.getColumnHeaders()));
            }
        }
        List<Subheading> subheading = repository.saveAll(subheadings);
        Map<Double,List<Documentation>> documentations = subheadings
                .stream()
                .filter(s -> s.getDocumentations() != null)
                .collect(Collectors.toMap(Subheading::getNumber, Subheading::getDocumentations));
        for (Double number : subheadings.stream().filter(s -> s.getDocumentations() != null)
                .map(Subheading::getNumber)
                .toList()){
            documentationService.update(documentations.get(number));
        }
        return subheading;
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
