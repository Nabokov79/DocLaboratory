package ru.nabokov.dataservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.dataservice.dto.type.NewTypeDto;
import ru.nabokov.dataservice.dto.type.TypeDto;
import ru.nabokov.dataservice.dto.type.UpdateTypeDto;
import ru.nabokov.dataservice.exceptions.BadRequestException;
import ru.nabokov.dataservice.exceptions.NotFoundException;
import ru.nabokov.dataservice.mapper.TypeMapper;
import ru.nabokov.dataservice.model.Documentation;
import ru.nabokov.dataservice.model.Type;
import ru.nabokov.dataservice.repository.DocumentationRepository;
import ru.nabokov.dataservice.repository.TypeRepository;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService {

    private final TypeRepository repository;
    private final TypeMapper mapper;
    private final DocumentationRepository documentationRepository;

    @Override
    public TypeDto save(NewTypeDto typeDto) {
        if (repository.existsByName(typeDto.getName())) {
            throw new BadRequestException(String.format("type=%s found.", typeDto.getName()));
        }
        Type type = repository.save(mapper.mapToNewType(typeDto));
        if (!typeDto.getDocumentationIds().isEmpty()) {
            type.setDocumentations(updateDocumentation(type, typeDto.getDocumentationIds()));
        }
        return mapper.mapToTypeDto(type);
    }

    @Override
    public TypeDto update(UpdateTypeDto typeDto) {
        if (!repository.existsById(typeDto.getId())) {
            throw new NotFoundException(String.format("type=%s not found for update.", typeDto.getName()));
        }
        Type type = mapper.mapToUpdateType(typeDto);
        if (!typeDto.getDocumentationIds().isEmpty()) {
            updateDocumentation(type, typeDto.getDocumentationIds());
        }
        return mapper.mapToTypeDto(repository.save(type));
    }

    @Override
    public Type get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Type with id=%s not found", id)));
    }

    @Override
    public List<TypeDto> getAll(String ids) {
        if (ids != null && ids.isBlank()){
            return mapper.mapToTypesDto(
                    repository.findAllById(Stream.of(ids.split(",")).map(Long::parseLong).toList()));
        }
        return mapper.mapToTypesDto(repository.findAll());
    }

    private List<Documentation> updateDocumentation(Type type, String documentationIds) {
        List<Documentation> documentations = documentationRepository.findAllById(
                Stream.of(documentationIds.split(",")).map(Long::parseLong).toList()
        );
        for (Documentation documentation : documentations) {
            documentation.setType(type);
        }
        return documentationRepository.saveAll(documentations);
    }
}
