package ru.nabokov.dataservice.service;

import ru.nabokov.dataservice.dto.place.NewPlaceDto;
import ru.nabokov.dataservice.dto.place.UpdatePlaceDto;
import ru.nabokov.dataservice.model.Place;

import java.util.List;

public interface PlaceService {

    List<Place> save(List<NewPlaceDto> placesDto);

    List<Place> update(List<UpdatePlaceDto> placesDto);
}
