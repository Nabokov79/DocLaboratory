package ru.nabokov.docservice.dto.client.pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class SubheadingDto {

    private Double number;
    private String heading;
    private String text;
    private List<DocumentationDto> documentations;

    @Override
    public String toString() {
        return "SubheadingDto{" +
                "number=" + number +
                ", heading='" + heading + '\'' +
                ", text='" + text + '\'' +
                ", documentations=" + documentations +
                '}';
    }
}
