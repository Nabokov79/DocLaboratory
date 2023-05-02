package ru.nabokov.patternservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.dto.client.TypeDto;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Краткая информацция о шаблонах отчетов")
public class ShortReportPatternDto {

    @Schema(description = "Индентификатор")
    private Long Id;
    @Schema(description = "Тип объекта шаблона")
    private TypeDto type;
}
