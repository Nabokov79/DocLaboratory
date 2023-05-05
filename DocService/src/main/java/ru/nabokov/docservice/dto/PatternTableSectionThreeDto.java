package ru.nabokov.docservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class PatternTableSectionThreeDto {

    private String name;
    private String text;
    private List<ColumnHeaderDto> columnHeaders;

    @Override
    public String toString() {
        return "PatternTableSectionThreeDto{" +
                "name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", columnHeaders=" + columnHeaders +
                '}';
    }
}
