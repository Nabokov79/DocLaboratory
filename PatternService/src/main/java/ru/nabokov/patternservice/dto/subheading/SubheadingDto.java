package ru.nabokov.patternservice.dto.subheading;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.dto.recommendation.RecommendationDto;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Полные данные подразделов раздела")
public class SubheadingDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Номер подраздела")
    private Double number;
    @Schema(description = "Заголовок подраздела")
    private String heading;
    @Schema(description = "Рекомендации")
    private List<RecommendationDto> recommendations;
}
