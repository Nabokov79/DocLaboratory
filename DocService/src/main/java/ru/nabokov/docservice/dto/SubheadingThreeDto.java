package ru.nabokov.docservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class SubheadingThreeDto {

    private Double number;
    private String heading;
    private List<ColumnHeaderDto> columnHeaders;

    @Override
    public String toString() {
        return "PatternTableSectionThreeDto{" +
                "number='" + number + '\'' +
                ", text='" + heading + '\'' +
                ", columnHeaders=" + columnHeaders +
                '}';
    }
}
