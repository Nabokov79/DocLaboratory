package ru.nabokov.dataservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.dataservice.dto.license.LicenseDto;
import ru.nabokov.dataservice.dto.license.NewLicenseDto;
import ru.nabokov.dataservice.dto.license.UpdateLicenseDto;
import ru.nabokov.dataservice.model.Licenses;
import java.util.List;

@Mapper(componentModel = "spring")
public interface LicenseMapper {

    Licenses mapToNewLicense(NewLicenseDto licenseDto);

    LicenseDto mapToLicenseDto(Licenses license);

    Licenses mapToUpdateLicense(UpdateLicenseDto licenseDto);

    List<LicenseDto> mapToLicensesDto(List<Licenses> licenses);
}
