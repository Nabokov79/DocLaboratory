package ru.nabokov.dataservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.dataservice.dto.documentation.DocumentationDto;
import ru.nabokov.dataservice.dto.documentation.NewDocumentationDto;
import ru.nabokov.dataservice.dto.documentation.UpdateDocumentationDto;
import ru.nabokov.dataservice.exceptions.BadRequestException;
import ru.nabokov.dataservice.exceptions.NotFoundException;
import ru.nabokov.dataservice.mapper.DocumentationMapper;
import ru.nabokov.dataservice.model.Documentation;
import ru.nabokov.dataservice.repository.DocumentationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocumentationServiceImpl implements DocumentationService {

    private final DocumentationRepository repository;
    private final DocumentationMapper mapper;

    @Override
    public List<DocumentationDto> save(List<NewDocumentationDto> documentationsDto) {
        validateByTitle(documentationsDto.stream().map(NewDocumentationDto::getTitle).toList());
        return mapper.mapToDocumentationDto(repository.saveAll(mapper.mapToNewDocumentation(documentationsDto)));
    }

    @Override
    public List<DocumentationDto> update(List<UpdateDocumentationDto> documentationsDto) {
        validateIds(documentationsDto.stream().map(UpdateDocumentationDto::getId).toList());
        return mapper.mapToDocumentationDto(repository.saveAll(mapper.mapToUpdateDocumentation(documentationsDto)));
    }

    @Override
    public List<DocumentationDto> getAll() {
        return mapper.mapToDocumentationDto(repository.findAll());
    }

    @Override
    public String delete(Long id) {
        Documentation documentation = repository.findById(id).orElseThrow(() -> new NotFoundException(
                        String.format("documentation with id=%s not found for delete.", id))
                );
        repository.deleteById(id);
        return String.join(" ", documentation.getView(), documentation.getNumber());
    }

    private void validateByTitle(List<String> titles) {
        Set<Documentation> documentations = repository.findAllByTitle(titles);
        if (documentations.size() != titles.size() && !documentations.isEmpty()) {
            throw new BadRequestException(String.format("documentations with title= %s found", titles));
        }
    }

    private void validateIds(List<Long> ids) {
        Map<Long, Documentation> documentations = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(Documentation::getId, subheading -> subheading));
        if (documentations.size() != ids.size() || documentations.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(documentations.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("documentations with ids= %s not found", ids));
        }
    }
}