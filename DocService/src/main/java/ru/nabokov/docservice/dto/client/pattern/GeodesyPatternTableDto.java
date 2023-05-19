package ru.nabokov.docservice.dto.client.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class GeodesyPatternTableDto {

    private long id;
    private String name;
    private List<ColumnHeaderDto> columnHeaders;
    private GeodesyCombinedColumnsDto combinedColumn;

    @Override
    public String toString() {
        return "GeodesyPatternTableDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", columnHeaders=" + columnHeaders +
                ", combinedColumn=" + combinedColumn +
                '}';
    }
}
