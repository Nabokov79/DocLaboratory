package ru.nabokov.docservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.docservice.model.sixthSection.SubheadingSection;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные шестого раздела")
public class SectionSixDto {

    @Schema(description = "Данные заголовка")
    private String heading;
    @Schema(description = "Данные раздела")
    private List<SubheadingSection> subheadings;
}
