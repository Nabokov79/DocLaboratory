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
    private Integer count;
}
