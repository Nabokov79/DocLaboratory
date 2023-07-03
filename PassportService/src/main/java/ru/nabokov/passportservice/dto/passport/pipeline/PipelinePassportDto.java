package ru.nabokov.passportservice.dto.passport.pipeline;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.passportservice.dto.client.ObjectDataDto;
import ru.nabokov.passportservice.dto.objectCharacteristics.ObjectCharacteristicsDto;
import ru.nabokov.passportservice.dto.repair.RepairDto;
import ru.nabokov.passportservice.dto.standardSizePipeDto.StandardSizePipeDto;
import ru.nabokov.passportservice.dto.survey.SurveyDto;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Паспортные данные объекта типа трубопровод")
public class PipelinePassportDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Объект обследования")
    private ObjectDataDto objectData;
    @Schema(description = "Характеристики объекта обследования")
    private List<ObjectCharacteristicsDto> characteristics;
    @Schema(description = "Данные типоразмеров трубы")
    private List<StandardSizePipeDto> standardSizePipe;
    @Schema(description = "Характеристики объекта обследования")
    private List<RepairDto> repairs;
    @Schema(description = "Характеристики объекта обследования")
    private List<SurveyDto> surveys;
}
