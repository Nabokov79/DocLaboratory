package ru.nabokov.patternservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.patternservice.model.PatternConclusion;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VisualProtocolPatternDto {

    private Long id;
    @Schema(description = "Заголовок протокола")
    private VisualProtocolHeader protocolHeader;
    @Schema(description = "Таблица протокола")
    private PatternTableDto patternTable;
    @Schema(description = "Заключение протокола")
    private PatternConclusion patternConclusion;
}
