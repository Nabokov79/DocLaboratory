package ru.nabokov.patternservice.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.nabokov.patternservice.dto.client.DivisionDto;
import ru.nabokov.patternservice.model.TitlePageData;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TitlePageDataMapper {

    public static TitlePageData toTitlePageData(DivisionDto divisionDto) {
        String[] format = divisionDto.getLicense().getDate().toString().split("-");
        TitlePageData titlePageData = new TitlePageData();
        titlePageData.setOrganizationType(divisionDto.getOrganization().getType());
        titlePageData.setOrganizationName(divisionDto.getOrganization().getName());
        titlePageData.setOrganizationBranch(divisionDto.getBranch());
        titlePageData.setOrganizationDivision(divisionDto.getDivision());
        titlePageData.setDivisionLicense(String.join(" ", divisionDto.getLicense().getDocument(),
                "№", divisionDto.getLicense().getNumber(),
                "от", String.join(".",format[2], format[1], format[0]),"г."));
        titlePageData.setDate(divisionDto.getLicense().getDate());
        return titlePageData;
    }
}
