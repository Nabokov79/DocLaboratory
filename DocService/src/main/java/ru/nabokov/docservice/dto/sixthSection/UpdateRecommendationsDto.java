package ru.nabokov.docservice.dto.sixthSection;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные изменения рекомендации")
public class UpdateRecommendationsDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id recommendation should not be blank")
    @Positive(message = "id recommendation must be positive")
    private Long id;
    @Schema(description = "Рекомендация")
    @NotBlank(message = "recommendation should not be blank")
    private String recommendation;
}
