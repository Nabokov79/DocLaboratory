package ru.nabokov.passportservice.dto.passport;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.passportservice.dto.belt.BeltDto;
import ru.nabokov.passportservice.dto.bottom.BottomDto;
import ru.nabokov.passportservice.dto.client.ObjectDataDto;
import ru.nabokov.passportservice.dto.objectCharacteristics.ObjectCharacteristicsDto;
import ru.nabokov.passportservice.dto.repair.RepairDto;
import ru.nabokov.passportservice.dto.survey.SurveyDto;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Паспортные данные объекта типа емкость")
public class PassportDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Объект обследования")
    private ObjectDataDto objectData;
    @Schema(description = "Данные поясов")
    private List<BeltDto> belts;
    @Schema(description = "Данные поясов")
    private List<BottomDto> bottoms;
    @Schema(description = "Характеристики объекта обследования")
    private List<ObjectCharacteristicsDto> characteristics;
    @Schema(description = "Характеристики объекта обследования")
    private List<RepairDto> repairs;
    @Schema(description = "Характеристики объекта обследования")
    private List<SurveyDto> surveys;
}
