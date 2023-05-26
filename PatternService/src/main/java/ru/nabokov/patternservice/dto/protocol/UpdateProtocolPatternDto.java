package ru.nabokov.patternservice.dto.protocol;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.dto.conclusion.UpdatePatternConclusionDto;
import ru.nabokov.patternservice.dto.protocolHeader.UpdateProtocolHeaderDto;
import ru.nabokov.patternservice.dto.table.UpdatePatternTableDto;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения информации шаблона протокола")
public class UpdateProtocolPatternDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id should not be blank")
    @Positive(message = "id can only be positive")
    private Long id;
    @Schema(description = "Индентификатор шаблона отчета")
    @NotNull(message = "pattern report id should not be blank")
    @Positive(message = "pattern report id can only be positive")
    private Long reportPatternId;
    @Schema(description = "Индентификатор шаблона отчета")
    @NotNull(message = "pattern section id should not be blank")
    @Positive(message = "pattern section id can only be positive")
    private Long sectionId;
    @Schema(description = "Заголовок протокола")
    @NotNull(message = "protocol header should not be blank")
    private UpdateProtocolHeaderDto protocolHeader;
    @Schema(description = "Таблица протокола")
    @NotNull(message = "protocol table should not be blank")
    private List<UpdatePatternTableDto> patternTables;
    @Schema(description = "Заключение протокола")
    @NotNull(message = "protocol conclusion should not be blank")
    private UpdatePatternConclusionDto patternConclusion;
}
