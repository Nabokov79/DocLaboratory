package ru.nabokov.dataservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.dataservice.dto.norm.NewNormsDto;
import ru.nabokov.dataservice.dto.norm.NormsDto;
import ru.nabokov.dataservice.dto.norm.UpdateNormsDto;
import ru.nabokov.dataservice.model.Norm;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NormsMapper {

    List<Norm> mapToNewNormsDto(List<NewNormsDto> normsDto);

    List<Norm> mapToUpdateNormsDto(List<UpdateNormsDto> normsDto);

    List<NormsDto> mapToNormsDto(List<Norm> norms);
}
