package ru.nabokov.patternservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.model.Drawing;
import ru.nabokov.patternservice.model.Header;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные раздела № 7")
public class PatternSectionSevenDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Заголовок раздела")
    private Header header;
    @Schema(description = "Список названий чертежей")
    private List<Drawing> drawings;
}
