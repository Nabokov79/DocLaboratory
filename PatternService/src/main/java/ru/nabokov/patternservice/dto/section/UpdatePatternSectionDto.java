package ru.nabokov.patternservice.dto.section;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.dto.drawing.UpdateDrawingDto;
import ru.nabokov.patternservice.dto.header.UpdateHeaderDto;
import ru.nabokov.patternservice.dto.subheading.UpdateSubheadingDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения информации в разделе № 1 шаблона отчета")
public class UpdatePatternSectionDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "pattern section one id should not be blank")
    @Positive(message = "pattern section one id can only be positive")
    private Long id;
    @Schema(description = "Индентификатор шаблона отчета")
    @NotNull(message = "pattern report id should not be blank")
    @Positive(message = "pattern report id can only be positive")
    private Long reportPatternId;
    @Schema(description = "Заголовок раздела")
    @NotNull(message = "header template of the first section should not be blank")
    private UpdateHeaderDto header;
    @Schema(description = "Список подзаголовоков раздела")
    private List<UpdateSubheadingDto> subheadings;
    @Schema(description = "Список чертежей")
    private List<UpdateDrawingDto> drawings;
}
