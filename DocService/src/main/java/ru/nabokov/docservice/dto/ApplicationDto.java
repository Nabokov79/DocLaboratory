package ru.nabokov.docservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.docservice.dto.title.AddressDto;
import ru.nabokov.docservice.dto.title.ObjectDataDto;

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
    private Boolean protocol;
    private String note;
    private List<EmployeeDto> employees;
}
