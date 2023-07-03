package ru.nabokov.passportservice.dto.objectCharacteristics;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные характеристики объекта")
public class NewObjectCharacteristicsDto {

    @Schema(description = "Индентификатор характеристики объекта")
    @NotNull(message = "id characteristic should not be blank")
    @Positive(message = "id characteristic can only be positive")
    private Long characteristicId;
    @Schema(description = "Значение характеристики объекта")
    private String meaning;
}
