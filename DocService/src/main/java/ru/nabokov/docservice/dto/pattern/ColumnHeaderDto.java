package ru.nabokov.docservice.dto.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ColumnHeaderDto {

    private Integer number;
    private String heading;

    @Override
    public String toString() {
        return "ColumnHeaderDto{" +
                "number=" + number +
                ", heading='" + heading + '\'' +
                '}';
    }
}
