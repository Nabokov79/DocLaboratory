package ru.nabokov.patternservice.service.protocol;

import ru.nabokov.patternservice.dto.place.NewPlaceDto;
import ru.nabokov.patternservice.dto.place.UpdatePlaceDto;
import ru.nabokov.patternservice.model.Element;

import java.util.List;

public interface PlaceService {

    void save(Element element, List<NewPlaceDto> placesDto);

    void update(Element element, List<UpdatePlaceDto> placesDto);
}
