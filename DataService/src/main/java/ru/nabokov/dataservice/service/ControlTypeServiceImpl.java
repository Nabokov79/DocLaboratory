package ru.nabokov.dataservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.dataservice.dto.controlType.ControlTypeDto;
import ru.nabokov.dataservice.dto.controlType.NewControlTypeDto;
import ru.nabokov.dataservice.dto.controlType.UpdateControlTypeDto;
import ru.nabokov.dataservice.exceptions.BadRequestException;
import ru.nabokov.dataservice.exceptions.NotFoundException;
import ru.nabokov.dataservice.mapper.ControlTypeMapper;
import ru.nabokov.dataservice.model.ControlType;
import ru.nabokov.dataservice.repository.ControlTypeRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ControlTypeServiceImpl implements ControlTypeService {

    private final ControlTypeRepository repository;
    private final ControlTypeMapper mapper;

    @Override
    public ControlTypeDto save(NewControlTypeDto typeControlDto) {
        if (repository.existsByName(typeControlDto.getName())) {
            throw new BadRequestException(
                    String.format("control type=%s found.", typeControlDto.getName())
            );
        }
        ControlType typeControl = mapper.mapToNewControlType(typeControlDto);
        typeControl.setName(typeControl.getName().toUpperCase());
        return mapper.mapToControlTypeDto(repository.save(typeControl));
    }

    @Override
    public ControlTypeDto update(UpdateControlTypeDto typeControlDto) {
        if (!repository.existsById(typeControlDto.getId())) {
            throw new NotFoundException(
                    String.format("control type=%s not found for update.", typeControlDto.getName())
            );
        }
        ControlType typeControl = mapper.mapToUpdateControlType(typeControlDto);
        return mapper.mapToControlTypeDto(repository.save(typeControl));
    }

    @Override
    public ControlType get(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(String.format("control type with id=%s not found", id)));
    }

    @Override
    public List<ControlTypeDto> getAll() {
        return mapper.mapToControlTypesDto(repository.findAll());
    }

    @Override
    public String delete(Long typId) {
        ControlType typeControl = repository.findById(typId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("control type with id=%s not found for delete.", typId))
                );
        repository.deleteById(typId);
        return typeControl.getName();
    }
}
