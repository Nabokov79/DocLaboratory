package ru.nabokov.docservice.dto.client.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PipelineProtocolPatternDto {

    private ProtocolHeaderDto protocolHeader;
    private PipelinePatternTableDto patternTable;
    private PatternConclusionDto patternConclusion;

    @Override
    public String toString() {
        return "PipelineProtocolPatternDto{" +
                "protocolHeader=" + protocolHeader +
                ", patternTable=" + patternTable +
                ", patternConclusion=" + patternConclusion +
                '}';
    }
}
