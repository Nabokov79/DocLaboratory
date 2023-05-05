package ru.nabokov.patternservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.patternservice.dto.client.Type;
import ru.nabokov.patternservice.model.TitlePattern;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные шаблона отчета")
public class ReportPatternDto {

    @Schema(description = "Индентификатор")
    private Long Id;
    @Schema(description = "Тип объекта шаблона")
    private Type type;
    @Schema(description = "Данные титульной страницы")
    private TitlePattern titlePattern;
    @Schema(description = "Данные шаблона первого раздела отчета")
    private PatternSectionOneDto patternSectionOne;
    @Schema(description = "Данные шаблона второго раздела отчета")
    private PatternSectionTwoDto patternSectionTwo;
    @Schema(description = "Данные шаблона третьего раздела отчета")
    private PatternSectionThreeDto patternSectionThree;
    @Schema(description = "Данные шаблона четвертого раздела отчета")
    private PatternSectionFourDto patternSectionFour;
    @Schema(description = "Данные шаблона пятого раздела отчета")
    private PatternSectionFiveDto patternSectionFive;
    @Schema(description = "Данные шаблона шестого раздела отчета")
    private PatternSectionSixDto patternSectionSix;
    @Schema(description = "Данные шаблона седьмого раздела отчета")
    private PatternSectionSevenDto patternSectionSeven;
}
