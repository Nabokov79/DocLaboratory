package ru.nabokov.passportservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.passportservice.dto.norms.TanksNormsDto;
import ru.nabokov.passportservice.dto.norms.UpdateTanksNormsDto;
import ru.nabokov.passportservice.model.norms.TankNorm;

@Mapper(componentModel = "spring")
public interface TankNormsMapper {

    TanksNormsDto mapToNormsDto(TankNorm norm);

    TankNorm mapToUpdateNormsDto(UpdateTanksNormsDto normsDto);


}
