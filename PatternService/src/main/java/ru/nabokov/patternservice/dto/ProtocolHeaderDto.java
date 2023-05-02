package ru.nabokov.patternservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProtocolHeaderDto {

    private long id;
    private Integer number;
    private String document;
    private String name;
    private String text;
    private String textMeasurements;
    private String location;
    private String admissibility;
}
