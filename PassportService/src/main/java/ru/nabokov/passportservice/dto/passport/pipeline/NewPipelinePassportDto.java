package ru.nabokov.passportservice.dto.passport.pipeline;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.passportservice.dto.objectCharacteristics.NewObjectCharacteristicsDto;
import ru.nabokov.passportservice.dto.repair.NewRepairDto;
import ru.nabokov.passportservice.dto.survey.NewSurveyDto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Новые паспортные данные объекта типа трубопровод")
public class NewPipelinePassportDto {

    @Schema(description = "Индентификатор объекта обследования")
    @NotNull(message = "id object data should not be blank")
    @Positive(message = "id object data can only be positive")
    private Long objectDataId;
    private List<NewObjectCharacteristicsDto> characteristics;
    @Schema(description = "Индентификаторы данных типоразмеров трубы")
    @NotNull(message = "standard size pipe should not be blank")
    @NotEmpty(message = "standard size pipe should not be empty")
    private List<Long> standardSizePipeIds;
    @Schema(description = "Характеристики объекта обследования")
    @NotNull(message = "characteristics should not be blank")
    @NotEmpty(message = "characteristics should not be empty")
    private List<NewRepairDto> repairs;
    @Schema(description = "Характеристики объекта обследования")
    @NotNull(message = "characteristics should not be blank")
    @NotEmpty(message = "characteristics should not be empty")
    private List<NewSurveyDto> surveys;
}
