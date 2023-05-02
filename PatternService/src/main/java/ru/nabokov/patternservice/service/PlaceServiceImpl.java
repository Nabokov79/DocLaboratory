package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.exceptions.BadRequestException;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.model.Place;
import ru.nabokov.patternservice.repository.PlaceRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository repository;

    @Override
    public void save(List<Place> places) {
        validate(places);
        repository.saveAll(places);
    }

    @Override
    public void update(List<Place> places) {
        validateIds(places.stream().map(Place::getId).toList());
        validate(places);
        repository.saveAll(places);
    }

    private void validate(List<Place> places) {
        for (Place place : places) {
            if (place.getPlace() == null) {
                throw new BadRequestException("place name cannot be blank");
            }
        }
    }

    private void validateIds(List<Long> ids) {
        Map<Long, Place> places = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(Place::getId, d -> d));
        if (places.size() != ids.size() || places.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(places.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("places with ids= %s not found", ids));
        }
    }
}
