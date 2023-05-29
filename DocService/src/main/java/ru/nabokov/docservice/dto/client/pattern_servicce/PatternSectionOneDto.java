package ru.nabokov.docservice.dto.client.pattern_servicce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class PatternSectionOneDto {

    private Long id;
    private HeaderDto header;
    private List<SubheadingSectionOneDto> subheadings;

    @Override
    public String toString() {
        return "PatternSectionOneDto{" +
                "id=" + id +
                ", header=" + header +
                ", subheadings=" + subheadings +
                '}';
    }
}
