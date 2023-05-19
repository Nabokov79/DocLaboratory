package ru.nabokov.docservice.dto.client.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PatternSectionFourDto {

    private HeaderDto header;
    private VisualProtocolPatternDto visualProtocolPattern;
    private PipelineProtocolPatternDto pipelineProtocolPattern;
    private TankProtocolPatternDto tankProtocolPattern;
    private GeodesyProtocolPatternDto geodesyProtocolPattern;
    private HardnessProtocolPatternDto hardnessProtocolPattern;

    @Override
    public String toString() {
        return "PatternSectionFourDto{" +
                "header=" + header +
                ", visualProtocolPattern=" + visualProtocolPattern +
                ", pipelineProtocolPattern=" + pipelineProtocolPattern +
                ", tankProtocolPattern=" + tankProtocolPattern +
                ", geodesyProtocolPattern=" + geodesyProtocolPattern +
                ", hardnessProtocolPattern=" + hardnessProtocolPattern +
                '}';
    }
}
