package ru.nabokov.docservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.docservice.model.Characteristic;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные второго раздела")
public class SectionTwoDto {

    @Schema(description = "Данные заголовка")
    private String heading;
    @Schema(description = "Данные подразделов")
    private List<Characteristic> secondSectionData;
}
