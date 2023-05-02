package ru.nabokov.patternservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.model.Header;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные раздела № 6")
public class PatternSectionSixDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Заголовок раздела")
    private Header header;
    @Schema(description = "Список подзаголовоков раздела")
    private List<SubheadingDto> subheadings;
}
