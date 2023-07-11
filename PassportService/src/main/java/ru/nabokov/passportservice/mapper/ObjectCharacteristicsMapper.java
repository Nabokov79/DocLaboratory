package ru.nabokov.passportservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.passportservice.dto.objectCharacteristics.NewObjectCharacteristicsDto;
import ru.nabokov.passportservice.dto.objectCharacteristics.UpdateObjectCharacteristicsDto;
import ru.nabokov.passportservice.model.ObjectCharacteristics;

@Mapper(componentModel = "spring")
public interface ObjectCharacteristicsMapper {

    ObjectCharacteristics mapFromNewObjectCharacteristics(NewObjectCharacteristicsDto characteristicDto);

    ObjectCharacteristics mapFromUpdateObjectCharacteristics(UpdateObjectCharacteristicsDto characteristicDto);
}
