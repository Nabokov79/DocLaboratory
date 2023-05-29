package ru.nabokov.docservice.dto.client.pattern_servicce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatternTableSectionThreeDto {

    private long id;
    private List<ColumnHeaderDto> columnHeaders;

    @Override
    public String toString() {
        return "PatternTableDto{" +
                "id=" + id +
                ", columnHeaders=" + columnHeaders +
                '}';
    }
}
