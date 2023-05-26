package ru.nabokov.patternservice.dto.section;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.dto.subheading.ShortSubheadingDto;
import ru.nabokov.patternservice.model.Header;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные третьего раздела отчета")
public class PatternSectionTwoDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Заголовок раздела")
    private Header header;
    @Schema(description = "Данные подзаголовоков раздела")
    private List<ShortSubheadingDto> subheadings;

    @Override
    public String toString() {
        return "PatternSectionTwoDto{" +
                "id=" + id +
                ", header=" + header +
                ", subheadings=" + subheadings +
                '}';
    }
}
