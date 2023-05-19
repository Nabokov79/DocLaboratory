package ru.nabokov.patternservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.dto.table.PatternTableDto;
import ru.nabokov.patternservice.model.PatternConclusion;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные шаблона протокола")
public class HardnessProtocolPatternDto {

    private Long id;
    @Schema(description = "Заголовок протокола")
    private ProtocolHeaderDto protocolHeader;
    @Schema(description = "Таблица протокола")
    private PatternTableDto patternTable;
    @Schema(description = "Заключение протокола")
    private PatternConclusion patternConclusion;
}
