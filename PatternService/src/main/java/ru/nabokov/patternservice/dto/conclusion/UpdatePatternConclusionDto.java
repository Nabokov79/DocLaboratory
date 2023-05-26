package ru.nabokov.patternservice.dto.conclusion;

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
@Schema(description = "Данные для изменения шаблона заключения")
public class UpdatePatternConclusionDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "conclusion pattern id should not be blank")
    @Positive(message = "conclusion pattern id can only be positive")
    private Long id;
    @Schema(description = "Текст заключения при отсутствии дефектов")
    @NotBlank(message = "isNotDefect should not be blank")
    private String isNotDefect;
    @Schema(description = "Текст заключения при наличии дефектов")
    @NotBlank(message = "isDefect should not be blank")
    private String isDefect;
}
