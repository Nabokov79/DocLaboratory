package ru.nabokov.patternservice.dto.defect;

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
@Schema(description = "Данные для изменения информации о дефекте")
public class UpdateDefectDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "drawing id should not be blank")
    @Positive(message = "drawing id can only be positive")
    private Long id;
    @Schema(description = "Название дефекта")
    @NotBlank(message = "defect name should not be blank")
    private String name;
}
