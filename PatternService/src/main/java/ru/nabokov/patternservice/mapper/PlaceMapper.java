package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.place.NewPlaceDto;
import ru.nabokov.patternservice.dto.place.UpdatePlaceDto;
import ru.nabokov.patternservice.model.Place;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlaceMapper {

    List<Place> mapToNewPlace(List<NewPlaceDto> placesDto);

    List<Place> mapToUpdatePlace(List<UpdatePlaceDto> placesDto);
}
