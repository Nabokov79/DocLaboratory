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
    @Schema(description = "Номер подраздела")
    @NotNull(message = "number should not be blank")
    @Positive(message = "number can only be positive")
    private Double number;
    @Schema(description = "Заголовок подраздела")
    @NotBlank(message = "heading subheading should not be blank")
    private String heading;
    @Schema(description = "Данные из паспорта объекта")
    @NotBlank(message = "meaning should not be blank")
    private String meaning;
}
