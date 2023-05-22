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
            updateDocumentation(type, typeDto.getDocumentationIds());
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
    public List<TypeDto> getAll() {
        return mapper.mapToTypesDto(repository.findAll());
    }

    private void updateDocumentation(Type type, List<Long> documentationIds) {
        List<Documentation> documentations = documentationRepository.findAllById(documentationIds);
        for (Documentation documentation : documentations) {
            documentation.setType(type);
            documentationRepository.saveAll(documentations);
        }
    }
}
