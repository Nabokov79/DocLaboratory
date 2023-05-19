package ru.nabokov.patternservice.dto.protocol;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.patternservice.dto.ProtocolHeaderDto;
import ru.nabokov.patternservice.dto.table.PatternTableDto;
import ru.nabokov.patternservice.model.PatternConclusion;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TankProtocolPatternDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Заголовок протокола")
    private ProtocolHeaderDto protocolHeader;
    @Schema(description = "Таблица протокола")
    private PatternTableDto patternTable;
    @Schema(description = "Заключение протокола")
    private PatternConclusion patternConclusion;
}
