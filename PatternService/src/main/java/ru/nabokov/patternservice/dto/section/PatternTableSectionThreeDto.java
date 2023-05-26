package ru.nabokov.patternservice.dto.section;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.patternservice.model.ColumnHeader;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatternTableSectionThreeDto {

    private long id;
    private List<ColumnHeader> columnHeaders;

    @Override
    public String toString() {
        return "PatternTableDto{" +
                "id=" + id +
                ", columnHeaders=" + columnHeaders +
                '}';
    }
}
