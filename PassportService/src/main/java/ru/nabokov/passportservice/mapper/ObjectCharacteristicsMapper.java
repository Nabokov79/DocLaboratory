package ru.nabokov.passportservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.passportservice.dto.objectCharacteristics.NewObjectCharacteristicsDto;
import ru.nabokov.passportservice.dto.objectCharacteristics.UpdateObjectCharacteristicsDto;
import ru.nabokov.passportservice.dto.passport.tank.NewTankPassportDto;
import ru.nabokov.passportservice.model.passport.Characteristic;
import ru.nabokov.passportservice.model.passport.ObjectCharacteristics;
import ru.nabokov.passportservice.model.passport.Passport;

@Mapper(componentModel = "spring")
public interface ObjectCharacteristicsMapper {

    ObjectCharacteristics mapFromNewObjectCharacteristics(NewObjectCharacteristicsDto characteristicDto);

    ObjectCharacteristics mapFromUpdateObjectCharacteristics(UpdateObjectCharacteristicsDto characteristicDto);
}
