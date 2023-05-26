package ru.nabokov.patternservice.dto.title;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные титульного листа")
public class TitlePatternDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Название документа")
    @NotBlank(message = "report name should not be blank")
    private String reportName;
    @Schema(description = "Первая чать текста под названием документа")
    @NotBlank(message = "text first should not be blank")
    private String textFirst;
    @Schema(description = "Название объекта обследования")
    @NotBlank(message = "object should not be blank")
    private String object;
    @Schema(description = "Вторая чать текста под названием документа")
    @NotBlank(message = "text second should not be blank")
    private String textSecond;
    @Schema(description = "Должность")
    @NotBlank(message = "post should not be blank")
    private String post;
    @Schema(description = "Название города, для нижней часть титульного листа")
    @NotBlank(message = "city name should not be blank")
    private String city;
}
