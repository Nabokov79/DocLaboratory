package ru.nabokov.patternservice.dto.conclusion;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения шаблона заключения")
public class PatternConclusionDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Текст заключения при отсутствии дефектов")
    private String isNotDefect;
    @Schema(description = "Текст заключения при наличии дефектов")
    private String isDefect;
}
