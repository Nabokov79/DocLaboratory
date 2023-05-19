package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.documentation.NewDocumentationDto;
import ru.nabokov.patternservice.dto.documentation.UpdateDocumentationDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.DocumentationMapper;
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
    private final DocumentationMapper mapper;

    @Override
    public void save(Subheading subheading, List<NewDocumentationDto> documentationsDto) {
        List<Documentation> documentations = mapper.mapToNewDocumentations(documentationsDto);
        for (Documentation document : documentations) {
            document.setSubheading(subheading);
        }
        repository.saveAll(documentations);
    }

    @Override
    public void update(Subheading subheading, List<UpdateDocumentationDto> documentationsDto) {
        validateIds(documentationsDto.stream().map(UpdateDocumentationDto::getId).toList());
        List<Documentation> documentations = mapper.mapToUpdateDocumentations(documentationsDto);
        for (Documentation document : documentations) {
            document.setSubheading(subheading);
        }
        repository.saveAll(documentations);
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
