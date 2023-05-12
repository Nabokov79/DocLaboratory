package ru.nabokov.docservice.dto.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class GeodesyProtocolPatternHeaderDto {

    private long id;
    private Integer number;
    private String document;
    private String name;
    private String text;
    private String textMeasurements;
    private String schemaHeader;

    @Override
    public String toString() {
        return "GeodesyProtocolPatternHeaderDto{" +
                "id=" + id +
                ", number=" + number +
                ", document='" + document + '\'' +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", textMeasurements='" + textMeasurements + '\'' +
                ", schemaHeader='" + schemaHeader + '\'' +
                '}';
    }
}
