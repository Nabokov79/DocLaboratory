package ru.nabokov.patternservice.dto.subheading;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.dto.documentation.UpdateDocumentationDto;
import ru.nabokov.patternservice.dto.recommendation.UpdateRecommendationDto;
import ru.nabokov.patternservice.dto.table.UpdatePatternTableDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения информации подразделов шаблона раздела отчета")
public class UpdateSubheadingDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "pattern section one id should not be blank")
    @Positive(message = "pattern section one id can only be positive")
    private Long id;
    @Schema(description = "Номер подраздела")
    @NotNull(message = "number should not be blank")
    @Positive(message = "number can only be positive")
    private String number;
    @Schema(description = "Заголовок подраздела")
    private String heading;
    @Schema(description = "Данные таблицы")
    private UpdatePatternTableDto patternTables;
    @Schema(description = "Документация")
    private List<UpdateDocumentationDto>  documentations;
    @Schema(description = "Рекомендации")
    private List<UpdateRecommendationDto> recommendations;
}
