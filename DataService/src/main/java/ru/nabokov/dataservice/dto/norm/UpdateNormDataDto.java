package ru.nabokov.dataservice.dto.norm;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения параметров браковки")
public class UpdateNormDataDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id should not be blank")
    @Positive(message = "id can only be positive")
    private Long id;
    @Schema(description = "Индентификатор элемента объекта обследования")
    @NotNull(message = "id element should not be blank")
    @Positive(message = "id element can only be positive")
    private Long elementId;
    @Schema(description = "Значение допуска отклонения от номинального значения")
    @NotNull(message = "size tolerance should not be blank")
    @Positive(message = "size tolerance can only be positive")
    private Float sizeTolerance;
    @Schema(description = "Предельно-минимальное допустимое значение в миллиметрах")
    @NotNull(message = "min should not be blank")
    @Positive(message = "min can only be positive")
    private Float min;
    @Schema(description = "Предельно-минимальное допустимое значение в процентах от номинальной толщины стенки элемента")
    private Integer percentMin;
}
