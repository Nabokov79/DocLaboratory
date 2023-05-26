package ru.nabokov.patternservice.dto.table;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.patternservice.dto.columnHeader.NewColumnHeaderDto;
import ru.nabokov.patternservice.dto.combinedColumns.NewCombinedColumnsDto;
import ru.nabokov.patternservice.dto.element.NewElementDto;

import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные нового шаблона таблицы")
public class NewPatternTableDto {

    @Schema(description = "Название таблицы")
    private String name;
    @Schema(description = "Заголовки колонок таблицы")
    @NotNull(message = "pattern table column headers should not be blank")
    private List<NewColumnHeaderDto> columnHeaders;
    @Schema(description = "Данные объедененной колонки")
    private NewCombinedColumnsDto combinedColumn;
    @Schema(description = "Элементы, содержащиеся в таблице")
    private List<NewElementDto> elements;
}
