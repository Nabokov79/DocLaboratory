package ru.nabokov.docservice.dto.sixthSection;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные новых подзаголовков раздела")
public class NewSubheadingsSixDto {

    @Schema(description = "Номер подраздела")
    @NotNull(message = "number should not be blank")
    @Positive(message = "number must be positive")
    private Double number;
    @Schema(description = "Название подраздела")
    @NotBlank(message = " heading should not be blank")
    private String heading;
    @Schema(description = "Заключение")
    @NotBlank(message = "conclusion should not be blank")
    private String conclusion;
    @Schema(description = "Рекомендации")
    @NotNull(message = "recommendations should not be blank")
    @NotEmpty(message = "recommendations should not be empty")
    private List<NewRecommendationsDto> recommendations;
}
