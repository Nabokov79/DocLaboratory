package ru.nabokov.docservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.docservice.model.License;
import ru.nabokov.docservice.model.title.Footer;
import ru.nabokov.docservice.model.title.TextCentered;
import ru.nabokov.docservice.model.title.TitleHeader;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные титульного листа")
public class TitleDto {

    @Schema(description = "Верхняя часть титульного листа")
    private TitleHeader header;
    @Schema(description = "Лицензия лаборатории")
    private License license;
    @Schema(description = "Текст по центру листа")
    private TextCentered text;
    @Schema(description = "Данные нижней части листа")
    private Footer footer;
}
