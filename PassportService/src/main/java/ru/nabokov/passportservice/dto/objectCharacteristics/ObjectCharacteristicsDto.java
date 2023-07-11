package ru.nabokov.passportservice.dto.objectCharacteristics;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.passportservice.model.Characteristic;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Характеристика объекта")
public class ObjectCharacteristicsDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Индентификатор характеристики объекта")
    private Characteristic characteristic;
    @Schema(description = "Значение характеристики объекта")
    private String meaning;
}
