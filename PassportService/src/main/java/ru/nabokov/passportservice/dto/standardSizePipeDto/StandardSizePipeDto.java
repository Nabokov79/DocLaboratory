package ru.nabokov.passportservice.dto.standardSizePipeDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные типоразмера трубы")
public class StandardSizePipeDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Диаметр трубы")
    private Integer diameter;
    @Schema(description = "Толщина стенки трубы")
    private Float thickness;
}
