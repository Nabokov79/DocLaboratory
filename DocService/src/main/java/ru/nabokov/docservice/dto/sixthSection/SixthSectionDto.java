package ru.nabokov.docservice.dto.sixthSection;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные шестого раздела")
public class SixthSectionDto {

    private Long id;
    @Schema(description = "Заголовок раздела")
    private String header;
    @Schema(description = "Данные подразделов")
    private List<SubheadingsDto> subheadings;
}
