package ru.nabokov.docservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class EmployeeDto {

    private Long id;
    private String name;
    private String patronymic;
    private String surname;
    private String post;
    private Integer serviceNumber;
    private List<CertificateDto> certificate;
    private List<MeasuringToolDto> measuringTool;

}
