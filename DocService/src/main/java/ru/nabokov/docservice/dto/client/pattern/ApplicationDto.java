package ru.nabokov.docservice.dto.client.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.docservice.dto.client.title.AddressDto;
import ru.nabokov.docservice.dto.ObjectDataDto;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class ApplicationDto {

    private Long id;
    private AddressDto address;
    private String work;
    private ObjectDataDto objectData;
    private LocalDate primaryData;
    private LocalDate repeatData;
    private Boolean report;
    private Boolean visual;
    private Boolean ultrasonic;
    private Boolean geodesy;
    private Boolean hardness;
    private String note;
    private List<EmployeeDto> employees;
}
