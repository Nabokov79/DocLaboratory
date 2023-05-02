package ru.nabokov.patternservice.dto.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DivisionDto {

    private Long id;
    private CityDto city;
    private OrganizationDto organization;
    private Integer index;
    private String branch;
    private String division;
    private LicenseDto license;
}
