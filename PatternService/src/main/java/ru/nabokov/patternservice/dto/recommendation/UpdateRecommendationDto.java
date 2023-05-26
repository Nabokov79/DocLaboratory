package ru.nabokov.patternservice.dto.recommendation;

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
@Schema(description = "Данные для изменения текста рекомендаций")
public class UpdateRecommendationDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "recommendation id should not be blank")
    @Positive(message = "recommendation id can only be positive")
    private Long id;
    @Schema(description = "Рекомендация")
    @NotBlank(message = "recommendation should not be blank")
    private String recommendation;
}
