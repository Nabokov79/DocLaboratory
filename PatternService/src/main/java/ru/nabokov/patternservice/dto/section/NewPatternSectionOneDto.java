package ru.nabokov.patternservice.dto.section;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.patternservice.dto.subheading.NewSubheadingDto;
import ru.nabokov.patternservice.model.Header;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные нового раздела № 1 шаблона отчета")
public class NewPatternSectionOneDto {

    @Schema(description = "Индентификатор шаблона отчета")
    @NotNull(message = "pattern report id should not be blank")
    @Positive(message = "pattern report id can only be positive")
    private Long reportPatternId;
    @Schema(description = "Заголовок раздела")
    @NotNull(message = "header template of the first section should not be blank")
    private Header header;
    @Schema(description = "Список подзаголовоков раздела")
    @NotNull(message = "list of subheadings of the first section should not be blank")
    private List<NewSubheadingDto> subheadings;

    @Override
    public String toString() {
        return "NewPatternSectionOneDto{" +
                "reportPatternId=" + reportPatternId +
                ", header=" + header +
                ", subheadings=" + subheadings +
                '}';
    }
}
