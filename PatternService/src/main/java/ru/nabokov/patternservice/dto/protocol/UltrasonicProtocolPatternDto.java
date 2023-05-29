package ru.nabokov.patternservice.dto.protocol;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.dto.conclusion.PatternConclusionDto;
import ru.nabokov.patternservice.dto.protocolHeader.ProtocolHeaderDto;
import ru.nabokov.patternservice.dto.table.PatternTableDto;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные шаблона ультразвуковой толщинометрии")
public class UltrasonicProtocolPatternDto {

    @Schema(description = "Индетнификатор")
    private Long id;
    @Schema(description = "Заголовок протокола")
    private ProtocolHeaderDto protocolHeader;
    @Schema(description = "Таблица протокола")
    private PatternTableDto patternTable;
    @Schema(description = "Заключение протокола")
    private PatternConclusionDto patternConclusion;

    @Override
    public String toString() {
        return "UltrasonicProtocolPatternDto{" +
                "id=" + id +
                ", protocolHeader=" + protocolHeader +
                ", patternTable=" + patternTable +
                ", patternConclusion=" + patternConclusion +
                '}';
    }
}
