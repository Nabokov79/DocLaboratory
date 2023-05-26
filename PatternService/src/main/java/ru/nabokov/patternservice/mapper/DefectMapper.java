package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.defect.NewDefectDto;
import ru.nabokov.patternservice.dto.defect.UpdateDefectDto;
import ru.nabokov.patternservice.model.Defect;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DefectMapper {

    List<Defect> mapToNewDefects(List<NewDefectDto> defectsDto);

    List<Defect> mapToUpdateDefects(List<UpdateDefectDto> defectsDto);
}
