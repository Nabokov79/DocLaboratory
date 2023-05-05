package ru.nabokov.docservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class PatternSectionSixDto {

    private HeaderDto header;
    private List<SubheadingDto> subheadings;

    @Override
    public String toString() {
        return "PatternSectionSixDto{" +
                "header=" + header +
                ", subheadings=" + subheadings +
                '}';
    }
}
