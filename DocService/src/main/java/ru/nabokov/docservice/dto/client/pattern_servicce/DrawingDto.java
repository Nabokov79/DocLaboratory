package ru.nabokov.docservice.dto.client.pattern_servicce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class DrawingDto {

    private Long id;
    private String type;
    private Integer number;
    private String name;
    private Integer count;
}
