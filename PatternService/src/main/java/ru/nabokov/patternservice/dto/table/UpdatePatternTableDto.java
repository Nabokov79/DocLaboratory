package ru.nabokov.patternservice.dto.table;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.dto.element.TankElement;
import ru.nabokov.patternservice.model.ColumnHeader;
import ru.nabokov.patternservice.model.CombinedColumns;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения информации шаблона таблицы")
public class UpdatePatternTableDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "pattern table id should not be blank")
    @Positive(message = "pattern table id can only be positive")
    private long id;
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
