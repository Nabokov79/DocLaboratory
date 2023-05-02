package ru.nabokov.patternservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.model.ColumnHeader;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные раздела № 3")
public class PatternTableSectionThreeDto {

    private String name;
    private String text;
    private List<ColumnHeader> columnHeaders;
}
