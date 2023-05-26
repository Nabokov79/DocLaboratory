package ru.nabokov.patternservice.service.protocol;

import ru.nabokov.patternservice.dto.defect.NewDefectDto;
import ru.nabokov.patternservice.dto.defect.UpdateDefectDto;
import ru.nabokov.patternservice.model.Element;

import java.util.List;

public interface DefectService {

    void save(Element element, List<NewDefectDto> defects);

    void update(Element element, List<UpdateDefectDto> defects);
}
