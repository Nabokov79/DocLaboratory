package ru.nabokov.dataservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.dataservice.dto.defect.NewDefectDto;
import ru.nabokov.dataservice.dto.defect.UpdateDefectDto;
import ru.nabokov.dataservice.model.Defect;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DefectMapper {

    List<Defect> mapToNewDefects(List<NewDefectDto> defectsDto);

    List<Defect> mapToUpdateDefects(List<UpdateDefectDto> defectsDto);
}
