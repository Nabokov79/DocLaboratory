package ru.nabokov.passportservice.dto.bottom;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные новых параметров днища бака")
public class NewBottomDto {

    @Schema(description = "Название днища")
    private String name;
    @Schema(description = "Толщина днища")
    @NotNull(message = "thickness bottom should not be blank")
    @Positive(message = "thickness bottom can only be positive")
    private Integer thickness;
    @Schema(description = "Толщина окрайка днища")
    @NotNull(message = "thickness edge should not be blank")
    @Positive(message = "thickness edge can only be positive")
    private Integer thicknessEdge;
}
