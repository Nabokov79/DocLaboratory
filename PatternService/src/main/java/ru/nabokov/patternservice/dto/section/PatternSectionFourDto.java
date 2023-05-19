package ru.nabokov.patternservice.dto.section;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.dto.*;
import ru.nabokov.patternservice.dto.protocol.GeodesyProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.TankProtocolPatternDto;
import ru.nabokov.patternservice.dto.protocol.VisualProtocolPatternDto;
import ru.nabokov.patternservice.model.Header;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные раздела № 4")
public class PatternSectionFourDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Заголовок раздела")
    private Header header;
    @Schema(description = "Протокол визуального и измерительного контроля")
    private VisualProtocolPatternDto visualProtocolPattern;
    @Schema(description = "Протокол ультразвуковой толщинометрии объектов типа трубопровод")
    private PipelineProtocolPatternDto pipelineProtocolPattern;
    @Schema(description = "Протокол ультразвуковой толщинометрии объектов типа трубопровод")
    private TankProtocolPatternDto tankProtocolPattern;
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
                ", pipelineProtocolPattern=" + pipelineProtocolPattern +
                ", tankProtocolPattern=" + tankProtocolPattern +
                ", geodesyProtocolPattern=" + geodesyProtocolPattern +
                ", hardnessProtocolPattern=" + hardnessProtocolPattern +
                '}';
    }
}
