package ru.nabokov.docservice.dto.client.pattern_servicce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class GeodesyProtocolPatternDto {

    private Long id;
    private ProtocolHeaderDto header;
    private List<PatternTableDto> patternTables;
    private PatternConclusionDto patternConclusion;
}
