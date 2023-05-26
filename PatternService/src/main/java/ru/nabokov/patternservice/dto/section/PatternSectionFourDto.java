package ru.nabokov.patternservice.dto.section;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.dto.protocol.GeodesyProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.HardnessProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.UltrasonicProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.VisualProtocolPatternDto;
import ru.nabokov.patternservice.dto.header.HeaderDto;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные раздела № 4")
public class PatternSectionFourDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Заголовок раздела")
    private HeaderDto header;
    @Schema(description = "Протокол визуального и измерительного контроля")
    private VisualProtocolPatternDto visualProtocolPattern;
    @Schema(description = "Протокол ультразвуковой толщинометрии")
    private UltrasonicProtocolPatternDto ultrasonicProtocolPattern;
    @Schema(description = "Протокол проведения геодезической съемки")
    private GeodesyProtocolPatternDto geodesyProtocolPattern;
    @Schema(description = "Протокол измерения твердости металла")
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
