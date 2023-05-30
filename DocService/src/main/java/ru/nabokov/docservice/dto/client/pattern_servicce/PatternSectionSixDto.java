package ru.nabokov.docservice.dto.client.pattern_servicce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class PatternSectionSixDto {

    private Long id;
    private HeaderDto header;
    private List<SubheadingDto> subheadings;
}
