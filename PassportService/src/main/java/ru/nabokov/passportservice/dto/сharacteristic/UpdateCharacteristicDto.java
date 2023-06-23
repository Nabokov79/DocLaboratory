package ru.nabokov.passportservice.dto.сharacteristic;

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
@Schema(description = "Данные для изменения паспортных данных объекта обследования")
public class UpdateCharacteristicDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id belt should not be blank")
    @Positive(message = "id belt can only be positive")
    private Long id;
    @Schema(description = "Индентификатор записи в шаблоне отчета")
    @NotNull(message = "id should not be blank")
    @Positive(message = "id can only be positive")
    private Long subheadingId;
    @Schema(description = "Данные из паспорта объекта")
    @NotBlank(message = "meaning should not be blank")
    private String meaning;
}
