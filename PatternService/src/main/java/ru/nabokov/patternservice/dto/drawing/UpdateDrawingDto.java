package ru.nabokov.patternservice.dto.drawing;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения информации о чертеже")
public class UpdateDrawingDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "drawing id should not be blank")
    @Positive(message = "drawing id can only be positive")
    private Long id;
    @Schema(description = "Тип чертежа")
    @NotBlank(message = "drawing type should not be blank")
    private String type;
    @Schema(description = "Номер чертежа")
    @NotNull(message = "drawing number should not be blank")
    @Positive(message = "drawing number can only be positive")
    private Integer number;
    @Schema(description = "Название чертежа")
    @NotBlank(message = "drawing name should not be blank")
    private String name;
}
