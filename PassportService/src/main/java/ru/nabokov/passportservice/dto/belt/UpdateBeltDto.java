package ru.nabokov.passportservice.dto.belt;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для обновления информации о поясе(стенке) бака")
public class UpdateBeltDto {

    @Schema(description = "Индентификатор ")
    @NotNull(message = "id belt should not be blank")
    @Positive(message = "id belt can only be positive")
    private Long id;
    @Schema(description = "Номер пояса")
    @NotNull(message = "number belt should not be blank")
    @Positive(message = "number belt can only be positive")
    private Integer number;
    @Schema(description = "Номер пояса")
    @NotNull(message = "number belt should not be blank")
    @Positive(message = "number belt can only be positive")
    private String name;
    @Schema(description = "Толщина пояса")
    @NotNull(message = "thickness belt should not be blank")
    @Positive(message = "thickness belt can only be positive")
    private Integer thickness;
}
