package ru.nabokov.patternservice.dto.subheading;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.dto.documentation.DocumentationDto;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные подрраздела раздела № 1")
public class SubheadingSectionOneDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Номер подраздела")
    private Double number;
    @Schema(description = "Заголовок подраздела")
    private String heading;
    @Schema(description = "Текст в подразделе")
    private String text;
    @Schema(description = "Нормативная документация")
    private List<DocumentationDto> documentations;

    @Override
    public String toString() {
        return "SubheadingSectionOneDto{" +
                "id=" + id +
                ", number=" + number +
                ", heading='" + heading + '\'' +
                ", text='" + text + '\'' +
                ", documentations=" + documentations +
                '}';
    }
}
