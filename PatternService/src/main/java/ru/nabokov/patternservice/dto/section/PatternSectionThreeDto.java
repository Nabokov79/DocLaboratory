package ru.nabokov.patternservice.dto.section;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.patternservice.dto.subheading.SubheadingSectionThreeDto;
import ru.nabokov.patternservice.model.Header;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные раздела № 3 шаблона отчета")
public class PatternSectionThreeDto {

    @Schema(description = "Заголовок раздела")
    private Header header;
    @Schema(description = "Список подзаголовоков раздела")
    @NotEmpty(message = "list of subheadings of the three section cannot be empty")
    private List<SubheadingSectionThreeDto> subheadings;

    @Override
    public String toString() {
        return "PatternSectionThreeDto{" +
                "header=" + header +
                ", subheadings=" + subheadings +
                '}';
    }
}
