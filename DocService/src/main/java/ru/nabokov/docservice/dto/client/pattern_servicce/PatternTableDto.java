package ru.nabokov.docservice.dto.client.pattern_servicce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class PatternTableDto {

    private Long id;
    private String name;
    private List<ColumnHeaderDto> columnHeaders;
    private CombinedColumnsDto combinedColumn;
    private List<ElementDto> elements;

    @Override
    public String toString() {
        return "PatternTableDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", columnHeaders=" + columnHeaders +
                ", combinedColumn=" + combinedColumn +
                ", elements=" + elements +
                '}';
    }
}
