package ru.nabokov.passportservice.service.passport;

import ru.nabokov.passportservice.dto.repair.NewRepairDto;
import ru.nabokov.passportservice.dto.repair.UpdateRepairDto;
import ru.nabokov.passportservice.model.passport.Repair;

import java.util.List;

public interface RepairService {

    List<Repair> save(List<NewRepairDto> repairsDto);

    List<Repair> update(List<UpdateRepairDto> repairDto);
}