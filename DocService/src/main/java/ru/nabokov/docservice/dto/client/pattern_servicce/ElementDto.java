package ru.nabokov.docservice.dto.client.pattern_servicce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class ElementDto {

    private Long id;
    private Integer item;
    private String name;
    private List<PlaceDto> places;
    private List<DefectDto> defects;
}
