package ru.nabokov.docservice.dto.client.pattern_servicce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class PatternSectionTwoDto {

    private Long id;
    private HeaderDto header;
    private List<ShortSubheadingDto> subheadings;

    @Override
    public String toString() {
        return "PatternSectionTwoDto{" +
                "id=" + id +
                ", header=" + header +
                ", subheadings=" + subheadings +
                '}';
    }
}
