package ru.nabokov.patternservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.model.TextCentered;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные титульного листа")
public class TitlePatternDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Данные текста по центру титульной страницы")
    private TextCentered textCentered;
}
