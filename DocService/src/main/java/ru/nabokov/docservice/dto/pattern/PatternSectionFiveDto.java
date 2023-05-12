package ru.nabokov.docservice.dto.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class PatternSectionFiveDto {

    private HeaderDto header;
    private List<SubheadingDto> subheadings;

    @Override
    public String toString() {
        return "PatternSectionFiveDto{" +
                "header=" + header +
                ", subheadings=" + subheadings +
                '}';
    }
}
