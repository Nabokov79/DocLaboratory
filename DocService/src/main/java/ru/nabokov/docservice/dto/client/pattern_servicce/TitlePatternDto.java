package ru.nabokov.docservice.dto.client.pattern_servicce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class TitlePatternDto {

    private Long id;
    private String reportName;
    private String textFirst;
    private String object;
    private String textSecond;
    private String post;
    private String city;
}
