package ru.nabokov.dataservice.dto.defect;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные дефекта")
public class DefectDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Название дефекта")
    private String name;
}
