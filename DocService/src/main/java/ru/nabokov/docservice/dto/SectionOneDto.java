package ru.nabokov.docservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.docservice.model.DataFirstSection;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные первого раздела")
public class SectionOneDto {

    @Schema(description = "Данные заголовка")
    private String heading;
    @Schema(description = "Данные подразделов")
    private List<DataFirstSection> dataFirstSections;
}
