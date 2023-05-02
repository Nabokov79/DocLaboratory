package ru.nabokov.patternservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.patternservice.model.ColumnHeader;
import ru.nabokov.patternservice.model.CombinedColumns;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatternTableDto {

    private long id;
    private String name;
    private List<ColumnHeader> columnHeaders;
    private CombinedColumns combinedColumn;
    private List<TankElement> elements;
}
