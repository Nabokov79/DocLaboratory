package ru.nabokov.docservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.docservice.model.thirdSection.RepairsTable;
import ru.nabokov.docservice.model.thirdSection.SurveysTable;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные третьего раздела")
public class SectionThreeDto {

    @Schema(description = "Данные заголовка")
    private String heading;
    @Schema(description = "Данные ремонтов объекта")
    private RepairsTable repairsTable;
    @Schema(description = "Данные обследований объекта")
    private SurveysTable surveysTable;
}
