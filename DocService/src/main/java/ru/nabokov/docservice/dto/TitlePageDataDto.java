package ru.nabokov.docservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
public class TitlePageDataDto {

    private String organizationType;
    private String organizationName;
    private String organizationBranch;
    private String organizationDivision;
    private String divisionLicense;
    private LocalDate date;

    @Override
    public String toString() {
        return "TitlePageDataDto{" +
                "organizationType='" + organizationType + '\'' +
                ", organizationName='" + organizationName + '\'' +
                ", organizationBranch='" + organizationBranch + '\'' +
                ", organizationDivision='" + organizationDivision + '\'' +
                ", divisionLicense='" + divisionLicense + '\'' +
                ", date=" + date +
                '}';
    }
}
