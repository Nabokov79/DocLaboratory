package ru.nabokov.patternservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.dto.client.TypeDto;
import ru.nabokov.patternservice.dto.header.HeaderDto;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Краткие данные шаблона отчета")
public class ShortReportPatternDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Тип объекта шаблона")
    private TypeDto type;
    @Schema(description = "Заголовок раздела")
    private List<HeaderDto> headers;
}
