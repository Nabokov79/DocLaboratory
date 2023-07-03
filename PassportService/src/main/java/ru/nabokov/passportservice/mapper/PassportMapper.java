package ru.nabokov.passportservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.passportservice.dto.passport.*;
import ru.nabokov.passportservice.dto.passport.tank.NewTankPassportDto;
import ru.nabokov.passportservice.dto.passport.tank.TankPassportDto;
import ru.nabokov.passportservice.dto.passport.tank.UpdateTankPassportDto;
import ru.nabokov.passportservice.model.passport.Passport;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PassportMapper {

    Passport mapFromNewPassportDto(NewTankPassportDto passportDto);

    Passport mapFromUpdatePassportDto(UpdateTankPassportDto passportDto);

    TankPassportDto mapToTankPassportDto(Passport passport);

    List<ShortPassportDto> mapToShortPassportDto(List<Passport> passports);
}
