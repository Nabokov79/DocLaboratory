package ru.nabokov.patternservice.dto.combinedColumns;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные новой объедененной колоноки")
public class NewCombinedColumnsDto {

    @Schema(description = "Номер первой колонки")
    @NotNull(message = "number first column should not be blank")
    @Positive(message = "number first column can only be positive")
    private Integer numberFirst;
    @Schema(description = "Название первой колонки")
    @NotBlank(message = "name first column should not be blank")
    private String nameFirst;
    @Schema(description = "Номер второй колонки")
    @NotNull(message = "number second column should not be blank")
    @Positive(message = "number second column can only be positive")
    private Integer numberSecond;
    @Schema(description = "Название второй колонки")
    @NotBlank(message = "name second column should not be blank")
    private String nameSecond;
    @Schema(description = "Название объедененной колонки")
    @NotBlank(message = "name combined column should not be blank")
    private String name;
}
