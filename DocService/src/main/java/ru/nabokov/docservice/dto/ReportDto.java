package ru.nabokov.docservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.docservice.dto.client.data_service.TypeDto;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные отчета")
public class ReportDto {

    @Schema(description = "Индентификатор отчета")
    private Long id;
    private TypeDto type;
    @Schema(description = "Данные титульной страницы")
    private TitleDto titlePattern;
    @Schema(description = "Данные шаблона первого раздела отчета")
    private SectionOneDto firstSection;
    @Schema(description = "Данные шаблона второго раздела отчета")
    private SectionTwoDto secondSection;
    @Schema(description = "Данные шаблона третьего раздела отчета")
    private SectionThreeDto thirdSection;
    @Schema(description = "Данные шаблона четвертого раздела отчета")
    private SectionFourDto sectionFour;
    @Schema(description = "Данные шаблона пятого раздела отчета")
    private SectionFiveDto sectionFive;
    @Schema(description = "Данные шаблона шестого раздела отчета")
    private SectionSixDto sixthSection;
    @Schema(description = "Данные шаблона седьмого раздела отчета")
    private SectionSevenDto seventhSection;
}
