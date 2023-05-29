package ru.nabokov.docservice.dto.client.pattern_servicce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class PatternSectionFourDto {

    private Long id;
    private HeaderDto header;
    private VisualProtocolPatternDto visualProtocolPattern;
    private UltrasonicProtocolPatternDto ultrasonicProtocolPattern;
    private GeodesyProtocolPatternDto geodesyProtocolPattern;
    private HardnessProtocolPatternDto hardnessProtocolPattern;

    @Override
    public String toString() {
        return "PatternSectionFourDto{" +
                "id=" + id +
                ", header=" + header +
                ", visualProtocolPattern=" + visualProtocolPattern +
                ", ultrasonicProtocolPattern=" + ultrasonicProtocolPattern +
                ", geodesyProtocolPattern=" + geodesyProtocolPattern +
                ", hardnessProtocolPattern=" + hardnessProtocolPattern +
                '}';
    }
}
