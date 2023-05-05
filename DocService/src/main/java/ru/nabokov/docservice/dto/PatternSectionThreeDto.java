package ru.nabokov.docservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class PatternSectionThreeDto {

    private HeaderDto header;
    private List<PatternTableSectionThreeDto> patternTables;

    @Override
    public String toString() {
        return "PatternSectionThreeDto{" +
                "header=" + header +
                ", patternTables=" + patternTables +
                '}';
    }
}
