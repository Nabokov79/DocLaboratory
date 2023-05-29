package ru.nabokov.docservice.dto.client.data_service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class LicenseDto {
    
    private Long id;   
    private String document;    
    private OrganizationDto organization;
    private String number;   
    private LocalDate date;
}
