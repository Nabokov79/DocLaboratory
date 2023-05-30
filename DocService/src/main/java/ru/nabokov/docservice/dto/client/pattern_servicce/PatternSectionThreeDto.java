package ru.nabokov.docservice.dto.client.pattern_servicce;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class PatternSectionThreeDto {

    @Schema(description = "Заголовок раздела")
    private HeaderDto header;
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
