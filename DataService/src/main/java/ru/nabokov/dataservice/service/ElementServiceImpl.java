package ru.nabokov.dataservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.dataservice.dto.element.ElementDto;
import ru.nabokov.dataservice.dto.element.NewElementDto;
import ru.nabokov.dataservice.dto.element.UpdateElementDto;
import ru.nabokov.dataservice.exceptions.NotFoundException;
import ru.nabokov.dataservice.mapper.ElementMapper;
import ru.nabokov.dataservice.model.Element;
import ru.nabokov.dataservice.repository.ElementRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ElementServiceImpl implements ElementService {

    private final ElementRepository repository;
    private final ElementMapper mapper;

    @Override
    public List<ElementDto> save(List<NewElementDto> elementsDto) {
        return mapper.mapToElementsDto(repository.saveAll(mapper.mapToNewElements(elementsDto)));
    }

    @Override
    public List<ElementDto> update(List<UpdateElementDto> elementsDto) {
        validateIds(elementsDto.stream().map(UpdateElementDto::getId).toList());
        return mapper.mapToElementsDto(repository.saveAll(mapper.mapToUpdateElements(elementsDto)));
    }

    private void validateIds(List<Long> ids) {
        Map<Long, Element> elements = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(Element::getId, n -> n));
        if (elements.size() != ids.size() || elements.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(elements.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("elements with ids= %s not found", ids));
        }
    }
}
