package ru.nabokov.docservice.dto.client.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class GeodesyProtocolPatternDto {

    private GeodesyProtocolPatternHeaderDto protocolHeader;
    private List<GeodesyPatternTableDto> patternTables;
    private PatternConclusionDto patternConclusion;

    @Override
    public String toString() {
        return "GeodesyProtocolPatternDto{" +
                "protocolHeader=" + protocolHeader +
                ", patternTables=" + patternTables +
                ", patternConclusion=" + patternConclusion +
                '}';
    }
}
