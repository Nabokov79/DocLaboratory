package ru.nabokov.patternservice.dto.recommendation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные рекомендации")
public class RecommendationDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Рекомендация")
    private String recommendation;
}
