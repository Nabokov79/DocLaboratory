package ru.nabokov.dataservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ElementServiceImpl implements ElementService {

    private final ElementRepository repository;
    private final ElementMapper mapper;
    private final DefectService defectService;
    private final PlaceService placeService;

    @Override
    public List<ElementDto> save(List<NewElementDto> elementsDto) {
        List<Element> elements = new ArrayList<>();
        for (NewElementDto elementDto : elementsDto) {
            Element element = mapper.mapToNewElement(elementDto);
            if (elementDto.getDefects() != null) {
                element.setDefects(defectService.save(elementDto.getDefects()));
            }
            if (elementDto.getPlaces() != null) {
                element.setPlaces(placeService.save(elementDto.getPlaces()));
            }
            elements.add(element);
        }
        return mapper.mapToElementsDto(repository.saveAll(elements));
    }

    @Override
    public List<ElementDto> update(List<UpdateElementDto> elementsDto) {
        validateIds(elementsDto.stream().map(UpdateElementDto::getId).toList());
        List<Element> elements = new ArrayList<>();
        for (UpdateElementDto elementDto : elementsDto) {
            Element element = mapper.mapToUpdateElement(elementDto);
            if (element.getDefects() != null) {
                element.setDefects(defectService.update(elementDto.getDefects()));
            }
            if (elementDto.getPlaces() != null) {
                element.setPlaces(placeService.update(elementDto.getPlaces()));
            }
            elements.add(element);
        }
        return mapper.mapToElementsDto(repository.saveAll(elements));
    }

    private void validateIds(List<Long> ids) {
        Map<Long, Element> elements = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(Element::getId, d -> d));
        if (elements.size() != ids.size() || elements.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(elements.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("elements with ids= %s not found", ids));
        }
    }
}
