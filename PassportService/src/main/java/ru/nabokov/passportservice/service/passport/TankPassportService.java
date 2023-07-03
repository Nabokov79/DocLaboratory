package ru.nabokov.passportservice.service.passport;

import ru.nabokov.passportservice.dto.passport.*;
import ru.nabokov.passportservice.dto.passport.tank.NewTankPassportDto;
import ru.nabokov.passportservice.dto.passport.tank.TankPassportDto;
import ru.nabokov.passportservice.dto.passport.tank.UpdateTankPassportDto;

import java.util.List;

public interface TankPassportService {

    TankPassportDto save(NewTankPassportDto passportDto);

    TankPassportDto update(UpdateTankPassportDto passportDto);

    TankPassportDto get(Long id);

    List<ShortPassportDto> getAll();

   void delete(Long id);
}
