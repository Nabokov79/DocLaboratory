package ru.nabokov.patternservice.dto.columnHeader;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные колонок")
public class ColumnHeaderDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Номер колонки таблицы")
    private Integer number;
    @Schema(description = "Название колонки таблицы")
    private String heading;
}
