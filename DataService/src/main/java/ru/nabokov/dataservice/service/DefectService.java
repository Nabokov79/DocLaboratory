package ru.nabokov.dataservice.service;

import ru.nabokov.dataservice.dto.defect.NewDefectDto;
import ru.nabokov.dataservice.dto.defect.UpdateDefectDto;
import ru.nabokov.dataservice.model.Defect;

import java.util.List;

public interface DefectService {

    List<Defect> save(List<NewDefectDto> defects);

    List<Defect> update(List<UpdateDefectDto> defects);
}
