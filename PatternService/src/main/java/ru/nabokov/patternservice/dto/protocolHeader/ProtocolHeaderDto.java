package ru.nabokov.patternservice.dto.protocolHeader;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные шаблона протокола")
public class ProtocolHeaderDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Номер протокола")
    private Integer number;
    @Schema(description = "Тип документа")
    private String document;
    @Schema(description = "Название документа")
    private String name;
    @Schema(description = "Текст под заголовком документа")
    private String text;
    @Schema(description = "Заголовок обзаца средств измерений")
    private String headerMeasurements;
    @Schema(description = "Текст указания на раположения мест измерений(контроля)")
    private String location;
    @Schema(description = "Текст указания погрешности измерения")
    private String admissibility;
}