package ru.nabokov.patternservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.patternservice.model.PatternConclusion;
import ru.nabokov.patternservice.model.PatternTable;
import ru.nabokov.patternservice.model.ProtocolHeader;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные шаблона нового протокола по геодезии")
public class NewGeodesyProtocolPatternDto {

    @Schema(description = "Индентификатор шаблона отчета")
    @NotNull(message = "pattern section id should not be blank")
    @Positive(message = "pattern section id can only be positive")
    private Long sectionPatternId;
    @Schema(description = "Заголовок протокола")
    @NotNull(message = "protocol header should not be blank")
    private ProtocolHeader protocolHeader;
    @Schema(description = "Список таблиц для протокола по геодезии")
    @NotNull(message = "protocol table should not be blank")
    @NotEmpty(message = "protocol table should not be empty")
    private List<PatternTable> patternTables;
    @Schema(description = "Заключение протокола")
    @NotNull(message = "protocol conclusion should not be blank")
    private PatternConclusion patternConclusion;
}
