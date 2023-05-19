package ru.nabokov.docservice.dto.sixthSection;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения рекомендаций")
public class UpdateSubheadingsSixDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id subheadings six section should not be blank")
    @Positive(message = "id subheadings six section must be positive")
    private Long id;
    @Schema(description = "Номер подраздела")
    @NotNull(message = "number should not be blank")
    @Positive(message = "number must be positive")
    private Double number;
    @Schema(description = "Название подраздела")
    @NotBlank(message = "heading should not be blank")
    private String heading;
    @Schema(description = "Заключение")
    @NotBlank(message = "conclusion should not be blank")
    private String conclusion;
    @Schema(description = "Рекомендации")
    @NotNull(message = "recommendations should not be blank")
    @NotEmpty(message = "recommendations should not be empty")
    private List<UpdateRecommendationsDto> recommendations;
}
