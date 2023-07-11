package ru.nabokov.passportservice.service;

import ru.nabokov.passportservice.dto.objectCharacteristics.NewObjectCharacteristicsDto;
import ru.nabokov.passportservice.dto.objectCharacteristics.UpdateObjectCharacteristicsDto;
import ru.nabokov.passportservice.model.ObjectCharacteristics;
import ru.nabokov.passportservice.model.Passport;

import java.util.List;

public interface ObjectCharacteristicsService {

    List<ObjectCharacteristics> save(Passport passport, List<NewObjectCharacteristicsDto> characteristicsDto);

    List<ObjectCharacteristics> update(Passport passport, List<UpdateObjectCharacteristicsDto> characteristicDto);
}
