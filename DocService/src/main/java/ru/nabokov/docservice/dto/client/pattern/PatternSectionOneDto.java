package ru.nabokov.docservice.dto.client.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class PatternSectionOneDto {

    private Long id;
    private HeaderDto header;
    private List<SubheadingDto> subheadings;

    @Override
    public String toString() {
        return "PatternSectionOneDto{" +
                "id=" + id +
                ", header=" + header +
                ", subheadings=" + subheadings +
                '}';
    }
}
