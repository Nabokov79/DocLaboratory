package ru.nabokov.patternservice.dto.subheading;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.patternservice.dto.recommendation.NewRecommendationDto;
import ru.nabokov.patternservice.dto.table.NewPatternTableDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные подразделов  шаблона раздела отчета")
public class NewSubheadingDto {

    @Schema(description = "Номер подраздела")
    @NotNull(message = "number should not be blank")
    @Positive(message = "number can only be positive")
    private String number;
    @Schema(description = "Заголовок подраздела")
    @NotBlank(message = "heading subheading should not be blank")
    private String heading;
    @Schema(description = "Текст в подразделе")
    private String text;
    @Schema(description = "Данные таблицы")
    private NewPatternTableDto patternTables;
    @Schema(description = "Рекомендации")
    private List<NewRecommendationDto> recommendations;

    @Override
    public String toString() {
        return "NewSubheadingDto{" +
                "number=" + number +
                ", heading='" + heading + '\'' +
                ", text='" + text + '\'' +
                ", patternTables=" + patternTables +
                ", recommendations=" + recommendations +
                '}';
    }
}
