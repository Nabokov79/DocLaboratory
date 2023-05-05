package ru.nabokov.docservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class HardnessProtocolPatternDto {

    private ProtocolHeaderDto protocolHeader;
    private PatternTableDto patternTable;
    private PatternConclusionDto patternConclusion;

    @Override
    public String toString() {
        return "HardnessProtocolPatternDto{" +
                "protocolHeader=" + protocolHeader +
                ", patternTable=" + patternTable +
                ", patternConclusion=" + patternConclusion +
                '}';
    }
}
