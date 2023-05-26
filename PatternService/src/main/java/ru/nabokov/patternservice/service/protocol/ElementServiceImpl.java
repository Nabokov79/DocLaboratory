package ru.nabokov.patternservice.service.protocol;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.element.NewElementDto;
import ru.nabokov.patternservice.dto.element.UpdateElementDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.ElementMapper;
import ru.nabokov.patternservice.model.Element;
import ru.nabokov.patternservice.repository.ElementRepository;
import java.util.*;
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
    public void save(List<NewElementDto> elementsDto) {
        Map<String , Element> elementsDb = repository.saveAll(mapper.mapToNewElements(elementsDto)).stream()
                                                                   .collect(Collectors.toMap(Element::getName, e -> e));
        for (NewElementDto elementDto : elementsDto) {
            if (elementDto.getDefects() != null) {
                defectService.save(elementsDb.get(elementDto.getName()), elementDto.getDefects());
            }
            if (elementDto.getPlaces() != null) {
                placeService.save(elementsDb.get(elementDto.getName()), elementDto.getPlaces());
            }
        }
    }

    @Override
    public void update(List<UpdateElementDto> elementsDto) {
        validateIds(elementsDto.stream().map(UpdateElementDto::getId).toList());
        Map<String , Element> elementsDb = repository.saveAll(mapper.mapToUpdateElements(elementsDto)).stream()
                                                                   .collect(Collectors.toMap(Element::getName, e -> e));
        for (UpdateElementDto elementDto : elementsDto) {
            if (elementDto.getDefects() != null) {
                defectService.update(elementsDb.get(elementDto.getName()), elementDto.getDefects());
            }
            if (elementDto.getPlaces() != null) {
                placeService.update(elementsDb.get(elementDto.getName()), elementDto.getPlaces());
            }
        }
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
