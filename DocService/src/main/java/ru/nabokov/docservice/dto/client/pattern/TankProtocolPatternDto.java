package ru.nabokov.docservice.dto.client.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class TankProtocolPatternDto {

    private ProtocolHeaderDto protocolHeader;
    private PatternTableDto patternTable;
    private PatternConclusionDto patternConclusion;

    @Override
    public String toString() {
        return "TankProtocolPatternDto{" +
                "protocolHeader=" + protocolHeader +
                ", patternTable=" + patternTable +
                ", patternConclusion=" + patternConclusion +
                '}';
    }
}
