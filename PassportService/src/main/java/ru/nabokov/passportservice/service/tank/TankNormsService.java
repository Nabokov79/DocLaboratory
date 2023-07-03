package ru.nabokov.passportservice.service.tank;

import ru.nabokov.passportservice.dto.norms.NewTanksNormsDto;
import ru.nabokov.passportservice.dto.norms.TanksNormsDto;
import ru.nabokov.passportservice.dto.norms.UpdateTanksNormsDto;

public interface TankNormsService {

    TanksNormsDto save(NewTanksNormsDto normsDto);

    TanksNormsDto update(UpdateTanksNormsDto normsDto);
}
