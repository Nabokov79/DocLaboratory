package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.passport.RepairDto;
import ru.nabokov.docservice.model.Repair;
import ru.nabokov.docservice.model.RepairsTable;

import java.util.List;

public interface RepairsService {

    List<Repair> save(RepairsTable repairsTable, List<RepairDto> repairsDto);
}
