package ru.nabokov.dataservice.dto.norm;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные элемента для норм")
public class ElementNormDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Название элемента")
    private String name;
}
