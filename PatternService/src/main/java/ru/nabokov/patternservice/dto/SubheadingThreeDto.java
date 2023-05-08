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
@Schema(description = "Данные шаблонов подразделов шаблона раздела № 3 отчета")
public class SubheadingThreeDto {

    private Long id;
    private Double number;
    private String heading;
    private List<ColumnHeader> columnHeaders;
}
