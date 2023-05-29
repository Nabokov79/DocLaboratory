package ru.nabokov.patternservice.dto.subheading;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.dto.section.PatternTableSectionThreeDto;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные подраздела третьего раздела отчета")
public class SubheadingSectionThreeDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Номер")
    private Double number;
    @Schema(description = "Заголовок")
    private String heading;
    @Schema(description = "Текст в подразделе")
    private String text;
    @Schema(description = "Таблица подраздела")
    private PatternTableSectionThreeDto patternTables;

    @Override
    public String toString() {
        return "SubheadingSectionThreeDto{" +
                "id=" + id +
                ", number=" + number +
                ", heading='" + heading + '\'' +
                ", text='" + text + '\'' +
                ", patternTables=" + patternTables +
                '}';
    }
}
