package ru.nabokov.passportservice.service.passport;

import ru.nabokov.passportservice.dto.objectCharacteristics.NewObjectCharacteristicsDto;
import ru.nabokov.passportservice.dto.objectCharacteristics.UpdateObjectCharacteristicsDto;
import ru.nabokov.passportservice.model.passport.ObjectCharacteristics;
import ru.nabokov.passportservice.model.passport.Passport;

import java.util.List;

public interface ObjectCharacteristicsService {

    List<ObjectCharacteristics> save(Passport passport, List<NewObjectCharacteristicsDto> characteristicsDto);

    List<ObjectCharacteristics> update(Passport passport, List<UpdateObjectCharacteristicsDto> characteristicDto);
}
