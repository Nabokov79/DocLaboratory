package ru.nabokov.docservice.dto.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class PatternSectionThreeDto {

    private HeaderDto header;
    private List<SubheadingThreeDto> subheadings;

    @Override
    public String toString() {
        return "PatternSectionThreeDto{" +
                "header=" + header +
                ", subheadings=" + subheadings +
                '}';
    }
}
