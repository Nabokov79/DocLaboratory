package ru.nabokov.docservice.dto.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PatternConclusionDto {

    private String isNotDefect;
    private String isDefect;

    @Override
    public String toString() {
        return "PatternConclusionDto{" +
                "isNotDefect='" + isNotDefect + '\'' +
                ", isDefect='" + isDefect + '\'' +
                '}';
    }
}
