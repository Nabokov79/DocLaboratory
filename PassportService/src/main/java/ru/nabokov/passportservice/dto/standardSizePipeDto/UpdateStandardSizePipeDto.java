package ru.nabokov.passportservice.dto.standardSizePipeDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения информации о типоразмере трубы")
public class UpdateStandardSizePipeDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id should not be blank")
    @Positive(message = "id can only be positive")
    private Long id;
    @Schema(description = "Диаметр трубы")
    @NotNull(message = "diameter pipe should not be blank")
    @Positive(message = "diameter pipe can only be positive")
    private Integer diameter;
    @Schema(description = "Толщина стенки трубы")
    @NotNull(message = "thickness pipe should not be blank")
    @Positive(message = "thickness pipe can only be positive")
    private Float thickness;
}
