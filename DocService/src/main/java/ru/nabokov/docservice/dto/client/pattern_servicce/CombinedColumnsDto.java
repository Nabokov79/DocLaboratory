package ru.nabokov.docservice.dto.client.pattern_servicce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CombinedColumnsDto {

    private Long id;
    private Integer numberFirst;
    private String nameFirst;
    private Integer numberSecond;
    private String nameSecond;
    private String name;
}
