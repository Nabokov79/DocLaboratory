package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.client.passport_service.RepairDto;
import ru.nabokov.docservice.dto.client.pattern_servicce.SubheadingSectionThreeDto;
import ru.nabokov.docservice.model.thirdSection.RepairsTable;

import java.util.List;

public interface RepairsTableService {

    RepairsTable save(SubheadingSectionThreeDto subheadingDto, List<RepairDto> repairs);
}
