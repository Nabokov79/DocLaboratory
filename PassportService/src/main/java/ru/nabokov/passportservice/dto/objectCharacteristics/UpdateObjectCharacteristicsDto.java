package ru.nabokov.passportservice.dto.objectCharacteristics;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения хпрактеристики объекта")
public class UpdateObjectCharacteristicsDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = " id object characteristics should not be blank")
    @Positive(message = "id object characteristics can only be positive")
    private Long id;
    @Schema(description = "Индентификатор характеристики объекта")
    @NotNull(message = "id characteristic should not be blank")
    @Positive(message = "id characteristic can only be positive")
    private Long characteristicId;
    @Schema(description = "Значение характеристики объекта")
    private String meaning;
}
