package ru.nabokov.patternservice.dto.section;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.dto.header.HeaderDto;
import ru.nabokov.patternservice.dto.subheading.SubheadingDto;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные раздела № 6")
public class PatternSectionSixDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Заголовок раздела")
    private HeaderDto header;
    @Schema(description = "Список подзаголовоков раздела")
    private List<SubheadingDto> subheadings;
}
