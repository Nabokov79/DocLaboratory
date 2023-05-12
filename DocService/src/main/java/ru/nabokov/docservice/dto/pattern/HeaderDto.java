package ru.nabokov.docservice.dto.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class HeaderDto {

    private Integer number;
    private String heading;

    @Override
    public String toString() {
        return "HeaderDto{" +
                "number=" + number +
                ", heading='" + heading + '\'' +
                '}';
    }
}
