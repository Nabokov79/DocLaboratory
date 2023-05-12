package ru.nabokov.docservice.dto.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class DrawingDto {

    private String type;
    private Integer number;
    private String name;

    @Override
    public String toString() {
        return "DrawingDto{" +
                "type='" + type + '\'' +
                ", number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
