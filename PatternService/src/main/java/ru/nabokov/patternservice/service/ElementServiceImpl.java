package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.exceptions.BadRequestException;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.model.Defect;
import ru.nabokov.patternservice.model.Element;
import ru.nabokov.patternservice.model.Place;
import ru.nabokov.patternservice.repository.ElementRepository;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ElementServiceImpl implements ElementService {

    private final ElementRepository repository;
    private final DefectService defectService;
    private final PlaceService placeService;

    @Override
    public void save(List<Element> elements) {
        validate(elements);
        Map<String , Element> elementsDb = repository.saveAll(elements).stream()
                                                                   .collect(Collectors.toMap(Element::getName, e -> e));
        for (Element element : elements) {
            if (element.getDefects() != null) {
                defectService.save(getDefects(elementsDb.get(element.getName()), element.getDefects()));
            }
            if (element.getPlaces() != null) {
                placeService.save(getPlaces(elementsDb.get(element.getName()), element.getPlaces()));
            }
        }
    }

    @Override
    public void update(List<Element> elements) {
        validate(elements);
        validateIds(elements.stream().map(Element::getId).toList());
        Map<String , Element> elementsDb = repository.saveAll(elements).stream()
                                                                   .collect(Collectors.toMap(Element::getName, e -> e));
        for (Element element : elements) {
            if (element.getDefects() != null) {
                defectService.update(getDefects(elementsDb.get(element.getName()), element.getDefects()));
            }
            if (element.getPlaces() != null) {
                placeService.update(getPlaces(elementsDb.get(element.getName()), element.getPlaces()));
            }
        }
    }

    private void validate(List<Element> elements) {
        if (elements == null || elements.isEmpty()) {
            throw new BadRequestException("elements list cannot be blank");
        }
        for (Element element : elements) {
            if (element.getItem() != null && element.getItem() <= 0) {
                throw new BadRequestException("element item can only be positive");
            }
            if (element.getName() == null) {
                throw new BadRequestException("element name should not be blank");
            }
            if (element.getItem() != null && element.getDefects() == null && element.getPlaces() == null) {
                throw new BadRequestException("defects list and place list should not be blank");
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

    private List<Defect> getDefects(Element element, List<Defect> defectsDto) {
        for (Defect defect : defectsDto) {
            defect.setElement(element);
        }
        return defectsDto;
    }

    private List<Place> getPlaces(Element element, List<Place> places) {
        for (Place place : places) {
            place.setElement(element);
        }
        return places;
    }
}
