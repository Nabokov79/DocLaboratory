package ru.nabokov.patternservice.dto.protocol;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.dto.conclusion.PatternConclusionDto;
import ru.nabokov.patternservice.dto.protocolHeader.ProtocolHeaderDto;
import ru.nabokov.patternservice.dto.table.PatternTableDto;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные шаблона протокола еодезической съемки")
public class GeodesyProtocolPatternDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Заголовок протокола")
    private ProtocolHeaderDto header;
    @Schema(description = "Список таблиц протокола")
    private List<PatternTableDto> patternTables;
    @Schema(description = "Заключение протокола")
    private PatternConclusionDto patternConclusion;
}
