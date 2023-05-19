package ru.nabokov.patternservice.dto.section;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.model.Drawing;
import ru.nabokov.patternservice.model.Header;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения информации в разделе № 7 шаблона отчета")
public class UpdatePatternSectionSevenDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "pattern section seven id should not be blank")
    @Positive(message = "pattern section seven id can only be positive")
    private Long id;
    @Schema(description = "Индентификатор шаблона отчета")
    @NotNull(message = "pattern report id should not be blank")
    @Positive(message = "pattern report id can only be positive")
    private Long reportPatternId;
    @Schema(description = "Заголовок раздела")
    @NotNull(message = "header template of the seven section should not be blank")
    private Header header;
    @Schema(description = "Список названий чертежей")
    @NotEmpty(message = "list of drawings of the seven section cannot be empty")
    private List<Drawing> drawings;

    @Override
    public String toString() {
        return "UpdatePatternSectionSevenDto{" +
                "id=" + id +
                ", reportPatternId=" + reportPatternId +
                ", header=" + header +
                ", drawings=" + drawings +
                '}';
    }
}
