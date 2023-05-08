package ru.nabokov.patternservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.patternservice.model.ColumnHeader;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные подразделов шаблона раздела № 3 отчета")
public class NewSubheadingThreeDto {

    @Schema(description = "Номер подраздела")
    @NotNull(message = "number should not be blank")
    @Positive(message = "number can only be positive")
    private Double number;
    @Schema(description = "Заголовок подраздела")
    @NotBlank(message = "heading subheading should not be blank")
    private String heading;
    @Schema(description = "Список заголовков таблицы")
    @NotEmpty(message = "column headers three section cannot be empty")
    private List<ColumnHeader> columnHeaders;
}
