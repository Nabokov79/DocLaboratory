package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.client.passport.RepairDto;
import ru.nabokov.docservice.dto.client.pattern.SubheadingThreeDto;
import ru.nabokov.docservice.model.thirdSection.RepairsTable;

import java.util.List;

public interface RepairsTableService {

    RepairsTable save(SubheadingThreeDto subheadingDto, List<RepairDto> repairs);
}
