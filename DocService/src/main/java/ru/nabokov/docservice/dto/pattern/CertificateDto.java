package ru.nabokov.docservice.dto.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.docservice.dto.OrganizationDto;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class CertificateDto {

    private long id;
    private String documentType;
    private String number;
    private ControlTypeDto type;
    private Integer level;
    private LocalDate start;
    private LocalDate end;
    private String points;
    private OrganizationDto organization;
}
