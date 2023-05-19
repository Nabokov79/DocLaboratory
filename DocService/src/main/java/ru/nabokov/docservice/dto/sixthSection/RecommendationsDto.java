package ru.nabokov.docservice.dto.sixthSection;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные рекомендаций")
public class RecommendationsDto {

    @Schema(description = "Рекомендация")
    private String recommendation;
}
