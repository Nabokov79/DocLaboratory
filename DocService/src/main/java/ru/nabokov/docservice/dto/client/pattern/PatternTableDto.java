package ru.nabokov.docservice.dto.client.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class PatternTableDto {

    private long id;
    private String name;
    private List<ColumnHeaderDto> columnHeaders;
    private CombinedColumnsDto combinedColumn;
    private List<TankElementDto> elements;

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
