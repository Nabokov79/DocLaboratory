package ru.nabokov.docservice.dto.client.pattern_servicce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ProtocolHeaderDto {

    private Long id;
    private Integer number;
    private String document;
    private String name;
    private String text;
    private String headerMeasurements;
    private String location;
    private String admissibility;
}