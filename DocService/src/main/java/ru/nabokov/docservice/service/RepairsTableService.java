package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.passport.RepairDto;
import ru.nabokov.docservice.dto.pattern.SubheadingThreeDto;
import ru.nabokov.docservice.model.RepairsTable;

import java.util.List;

public interface RepairsTableService {

    RepairsTable save(SubheadingThreeDto subheadingDto, List<RepairDto> repairs);
}
