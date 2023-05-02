package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.model.Place;
import java.util.List;

public interface PlaceService {

    void save(List<Place> places);

    void update(List<Place> places);
}
