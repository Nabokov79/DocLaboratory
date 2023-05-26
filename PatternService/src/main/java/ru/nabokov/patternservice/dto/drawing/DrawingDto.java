package ru.nabokov.patternservice.dto.drawing;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные чертежа")
public class DrawingDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Тип чертежа")
    private String type;
    @Schema(description = "Номер чертежа")
    private Integer number;
    @Schema(description = "Название чертежа")
    private String name;
}
