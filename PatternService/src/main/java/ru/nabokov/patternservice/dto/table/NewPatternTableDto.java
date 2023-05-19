package ru.nabokov.patternservice.dto.table;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.dto.element.TankElement;
import ru.nabokov.patternservice.model.ColumnHeader;
import ru.nabokov.patternservice.model.CombinedColumns;
import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные нового шаблона таблицы")
public class NewPatternTableDto {

    @Schema(description = "Название таблицы")
    private String name;
    @Schema(description = "Заголовки колонок таблицы")
    @NotNull(message = "pattern table column headers should not be blank")
    private List<ColumnHeader> columnHeaders;
    @Schema(description = "Данные объедененной колонки")
    private CombinedColumns combinedColumn;
    @Schema(description = "Элементы, содержащиеся в таблице")
    private List<TankElement> elements;
}
