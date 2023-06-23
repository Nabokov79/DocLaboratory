package ru.nabokov.passportservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.passportservice.dto.сharacteristic.NewCharacteristicDto;
import ru.nabokov.passportservice.dto.сharacteristic.UpdateCharacteristicDto;
import ru.nabokov.passportservice.model.Characteristic;

@Mapper(componentModel = "spring")
public interface CharacteristicMapper {

    Characteristic mapFromNewCharacteristics(NewCharacteristicDto characteristicsDto);

    Characteristic mapFromUpdateCharacteristics(UpdateCharacteristicDto characteristicsDto);
}
