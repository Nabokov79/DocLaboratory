package ru.nabokov.docservice.dto.client.pattern_servicce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class VisualProtocolPatternDto {

    private Long id;
    private ProtocolHeaderDto protocolHeader;
    private PatternTableDto patternTable;
    private PatternConclusionDto patternConclusion;

    @Override
    public String toString() {
        return "VisualProtocolPatternDto{" +
                "id=" + id +
                ", protocolHeader=" + protocolHeader +
                ", patternTable=" + patternTable +
                ", patternConclusion=" + patternConclusion +
                '}';
    }
}
