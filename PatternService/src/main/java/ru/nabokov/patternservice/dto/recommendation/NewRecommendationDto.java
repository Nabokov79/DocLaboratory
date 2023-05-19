package ru.nabokov.patternservice.dto.recommendation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные новых рекомендаций")
public class NewRecommendationDto {

    @Schema(description = "Рекомендация")
    @NotBlank(message = "recommendation should not be blank")
    private String recommendation;
}
