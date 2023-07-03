package ru.nabokov.patternservice.dto.table;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.dto.columnHeader.ColumnHeaderDto;
import ru.nabokov.patternservice.dto.combinedColumns.CombinedColumnsDto;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные шаблона таблицы протокола")
public class PatternTableDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Название таблицы")
    private String name;
    @Schema(description = "Данные колонок таблицы")
    private List<ColumnHeaderDto> columnHeaders;
    @Schema(description = "Данные объедененной колоноки таблицы")
    private CombinedColumnsDto combinedColumn;

    @Override
    public String toString() {
        return "PatternTableDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", columnHeaders=" + columnHeaders +
                ", combinedColumn=" + combinedColumn +
                '}';
    }
}
