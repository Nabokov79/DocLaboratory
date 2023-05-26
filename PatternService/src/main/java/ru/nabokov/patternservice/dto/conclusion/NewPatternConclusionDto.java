package ru.nabokov.patternservice.dto.conclusion;

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
@Schema(description = "Данные шаблона заключения")
public class NewPatternConclusionDto {

    @Schema(description = "Текст заключения при отсутствии дефектов")
    @NotBlank(message = "isNotDefect should not be blank")
    private String isNotDefect;
    @Schema(description = "Текст заключения при наличии дефектов")
    @NotBlank(message = "isDefect should not be blank")
    private String isDefect;
}
