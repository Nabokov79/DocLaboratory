package ru.nabokov.patternservice.dto.title;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные титульного листа")
public class TitlePatternDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Название документа")
    private String reportName;
    @Schema(description = "Первая чать текста под названием документа")
    private String textFirst;
    @Schema(description = "Название объекта обследования")
    private String object;
    @Schema(description = "Вторая чать текста под названием документа")
    private String textSecond;
    @Schema(description = "Должность")
    private String post;
    @Schema(description = "Название города, для нижней часть титульного листа")
    private String city;
}
