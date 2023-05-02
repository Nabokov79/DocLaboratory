package ru.nabokov.patternservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.patternservice.model.Header;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные раздела № 3 шаблона отчета")
public class PatternSectionThreeDto {

    @Schema(description = "Заголовок раздела")
    private Header header;
    @Schema(description = "Таблицы раздела")
    private List<PatternTableSectionThreeDto> patternTables;
}
