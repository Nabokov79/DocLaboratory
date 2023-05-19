package ru.nabokov.docservice.dto.client.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MeasuringToolDto {

    private Long id;
    private String name;
    private String model;
    private Integer workNumber;
    private String certificateNumber;
    private ControlTypeDto type;
    private EmployeeDto employee;
}
