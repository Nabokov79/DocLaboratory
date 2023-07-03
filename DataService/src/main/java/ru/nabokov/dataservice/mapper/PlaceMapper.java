package ru.nabokov.dataservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.dataservice.dto.place.NewPlaceDto;
import ru.nabokov.dataservice.dto.place.UpdatePlaceDto;
import ru.nabokov.dataservice.model.Place;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PlaceMapper {

    List<Place> mapToNewPlace(List<NewPlaceDto> placesDto);

    List<Place> mapToUpdatePlace(List<UpdatePlaceDto> placesDto);
}
