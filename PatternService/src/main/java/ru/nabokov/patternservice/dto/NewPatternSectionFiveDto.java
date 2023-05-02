package ru.nabokov.patternservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.patternservice.model.Header;
import ru.nabokov.patternservice.model.Subheading;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные нового раздела № 5 шаблона отчета")
public class NewPatternSectionFiveDto {

    @Schema(description = "Индентификатор шаблона отчета")
    @NotNull(message = "pattern report id should not be blank")
    @Positive(message = "pattern report id can only be positive")
    private Long reportPatternId;
    @Schema(description = "Заголовок раздела")
    @NotNull(message = "header template of the first section should not be blank")
    private Header header;
    @Schema(description = "Список подзаголовоков раздела")
    @NotEmpty(message = "list of subheadings of the first section cannot be empty")
    private List<Subheading> subheadings;
}
