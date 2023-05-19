package ru.nabokov.patternservice.dto.protocol;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VisualProtocolHeader {

    private long id;
    private Integer number;
    private String document;
    private String name;
    private String text;
    private String textMeasurements;
}
