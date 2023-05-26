package ru.nabokov.patternservice.dto.section;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.dto.header.HeaderDto;
import ru.nabokov.patternservice.dto.subheading.SubheadingSectionOneDto;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные раздела № 1")
public class PatternSectionOneDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Заголовок раздела")
    private HeaderDto header;
    @Schema(description = "Список подзаголовоков раздела")
    private List<SubheadingSectionOneDto> subheadings;

    @Override
    public String toString() {
        return "PatternSectionOneDto{" +
                "id=" + id +
                ", header=" + header +
                ", subheadings=" + subheadings +
                '}';
    }
}
