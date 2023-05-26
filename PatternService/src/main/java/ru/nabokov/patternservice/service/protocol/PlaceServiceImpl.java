package ru.nabokov.patternservice.service.protocol;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.place.NewPlaceDto;
import ru.nabokov.patternservice.dto.place.UpdatePlaceDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.PlaceMapper;
import ru.nabokov.patternservice.model.Element;
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
    private final PlaceMapper mapper;

    @Override
    public void save(Element element, List<NewPlaceDto> placesDto) {
        repository.saveAll(setElement(element, mapper.mapToNewPlace(placesDto)));
    }

    @Override
    public void update(Element element, List<UpdatePlaceDto> placesDto) {
        validateIds(placesDto.stream().map(UpdatePlaceDto::getId).toList());
        repository.saveAll(setElement(element, mapper.mapToUpdatePlace(placesDto)));
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

    private List<Place> setElement(Element element, List<Place> places) {
        for (Place place : places) {
            place.setElement(element);
        }
        return places;
    }
}
