package ru.nabokov.patternservice.dto.columnHeader;

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
@Schema(description = "Данные новых колонок")
public class NewColumnHeaderDto {

    @Schema(description = "Номер колонки таблицы")
    @NotNull(message = "number should not be blank")
    @Positive(message = "number can only be positive")
    private Integer number;
    @Schema(description = "Название колонки таблицы")
    @NotBlank(message = "heading should not be blank")
    private String heading;
}
