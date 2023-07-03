package ru.nabokov.passportservice.service.passport;

import ru.nabokov.passportservice.dto.сharacteristic.CharacteristicDto;
import ru.nabokov.passportservice.dto.сharacteristic.NewCharacteristicDto;
import ru.nabokov.passportservice.dto.сharacteristic.UpdateCharacteristicDto;
import ru.nabokov.passportservice.model.passport.Characteristic;
import java.util.List;

public interface CharacteristicService {

    List<CharacteristicDto> save(List<NewCharacteristicDto> characteristicsDto);

    List<CharacteristicDto> update(List<UpdateCharacteristicDto> characteristicDto);

    List<Characteristic> getAllById(List<Long> ids);
}
