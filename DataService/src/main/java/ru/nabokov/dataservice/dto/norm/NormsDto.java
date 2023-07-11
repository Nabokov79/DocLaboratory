package ru.nabokov.dataservice.dto.norm;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.dataservice.dto.type.TypeDto;

@Setter
@Getter
@AllArgsConstructor
public class NormsDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Тип объекта обследования")
    private TypeDto type;
    @Schema(description = "Элемент объекта обследования")
    private ElementNormDto element;
    @Schema(description = "Значение допуска отклонения от номинального значения")
    private Float sizeTolerance;
    @Schema(description = "Предельно-минимальное допустимое значение в миллиметрах")
    private Float min;
    @Schema(description = "Предельно-минимальное допустимое значение в процентах от номинальной толщины стенки элемента")
    private Integer percentMin;
}
