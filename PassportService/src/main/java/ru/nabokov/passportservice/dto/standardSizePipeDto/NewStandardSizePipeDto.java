package ru.nabokov.passportservice.dto.standardSizePipeDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Новые данные типоразмера трубы")
public class NewStandardSizePipeDto {

    @Schema(description = "Диаметр трубы")
    @NotNull(message = "diameter pipe should not be blank")
    @Positive(message = "diameter pipe can only be positive")
    private Integer diameter;
    @Schema(description = "Толщина стенки трубы")
    @NotNull(message = "thickness pipe should not be blank")
    @Positive(message = "thickness pipe can only be positive")
    private Float thickness;
}
