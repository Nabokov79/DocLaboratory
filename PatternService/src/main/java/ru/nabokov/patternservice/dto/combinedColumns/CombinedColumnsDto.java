package ru.nabokov.patternservice.dto.combinedColumns;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные объедененной колоноки")
public class CombinedColumnsDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Номер первой колонки")
    private Integer numberFirst;
    @Schema(description = "Название первой колонки")
    private String nameFirst;
    @Schema(description = "Номер второй колонки")
    private Integer numberSecond;
    @Schema(description = "Название второй колонки")
    private String nameSecond;
    @Schema(description = "Название объедененной колонки")
    private String name;
}
