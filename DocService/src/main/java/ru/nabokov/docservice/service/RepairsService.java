package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.client.passport_service.RepairDto;
import ru.nabokov.docservice.model.thirdSection.Repair;
import ru.nabokov.docservice.model.thirdSection.RepairsTable;

import java.util.List;

public interface RepairsService {

    List<Repair> save(RepairsTable repairsTable, List<RepairDto> repairsDto);
}
