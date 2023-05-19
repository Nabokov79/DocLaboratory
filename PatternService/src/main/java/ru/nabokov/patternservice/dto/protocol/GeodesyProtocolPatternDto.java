package ru.nabokov.patternservice.dto.protocol;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.dto.GeodesyPatternTable;
import ru.nabokov.patternservice.dto.GeodesyProtocolPatternHeaderDto;
import ru.nabokov.patternservice.model.PatternConclusion;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные шаблона протокола по геодезии")
public class GeodesyProtocolPatternDto {

    private Long id;
    @Schema(description = "Заголовок протокола")
    private GeodesyProtocolPatternHeaderDto protocolHeader;
    @Schema(description = "Список таблиц протокола")
    private List<GeodesyPatternTable> patternTables;
    @Schema(description = "Заключение протокола")
    private PatternConclusion patternConclusion;
}
