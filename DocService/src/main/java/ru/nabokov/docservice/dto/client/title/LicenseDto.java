package ru.nabokov.docservice.dto.client.title;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.docservice.dto.OrganizationDto;

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
