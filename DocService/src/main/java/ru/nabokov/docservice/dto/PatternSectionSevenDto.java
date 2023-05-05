package ru.nabokov.docservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class PatternSectionSevenDto {

    private HeaderDto header;
    private List<DrawingDto> drawings;

    @Override
    public String toString() {
        return "PatternSectionSevenDto{" +
                "header=" + header +
                ", drawings=" + drawings +
                '}';
    }
}
