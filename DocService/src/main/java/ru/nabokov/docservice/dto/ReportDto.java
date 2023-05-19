package ru.nabokov.docservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.docservice.model.*;
import ru.nabokov.docservice.model.seventhSection.SeventhSection;
import ru.nabokov.docservice.model.thirdSection.ThirdSection;
import ru.nabokov.docservice.model.title.Title;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные отчета")
public class ReportDto {

    @Schema(description = "Индентификатор отчета")
    private long id;
    @Schema(description = "Титульный лист")
    private Title title;
    @Schema(description = "Первый раздел")
    private FirstSection firstSection;
    @Schema(description = "Второй раздел")
    private SecondSection secondSection;
    @Schema(description = "Третий раздел")
    private ThirdSection thirdSection;
    @Schema(description = "Седьмой раздел")
    private SeventhSection seventhSection;
}
