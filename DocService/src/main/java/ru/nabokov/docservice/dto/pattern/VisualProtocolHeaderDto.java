package ru.nabokov.docservice.dto.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class VisualProtocolHeaderDto {

    private long id;
    private Integer number;
    private String document;
    private String name;
    private String text;
    private String textMeasurements;

    @Override
    public String toString() {
        return "VisualProtocolHeaderDto{" +
                "id=" + id +
                ", number=" + number +
                ", document='" + document + '\'' +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", textMeasurements='" + textMeasurements + '\'' +
                '}';
    }
}
