package ru.nabokov.dataservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.dataservice.dto.place.NewPlaceDto;
import ru.nabokov.dataservice.dto.place.UpdatePlaceDto;
import ru.nabokov.dataservice.exceptions.NotFoundException;
import ru.nabokov.dataservice.mapper.PlaceMapper;
import ru.nabokov.dataservice.model.Place;
import ru.nabokov.dataservice.repository.PlaceRepository;
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
    public List<Place> save(List<NewPlaceDto> placesDto) {
        return repository.saveAll(mapper.mapToNewPlace(placesDto));
    }

    @Override
    public List<Place> update(List<UpdatePlaceDto> placesDto) {
        validateIds(placesDto.stream().map(UpdatePlaceDto::getId).toList());
        return repository.saveAll(mapper.mapToUpdatePlace(placesDto));
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
