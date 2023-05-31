package ru.nabokov.patternservice.dto.drawing;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные нового чертежа")
public class NewDrawingDto {

    @Schema(description = "Тип чертежа")
    @NotBlank(message = "drawing type should not be blank")
    private String type;
    @Schema(description = "Номер чертежа")
    @NotNull(message = "drawing number should not be blank")
    @Positive(message = "drawing number can only be positive")
    private Integer number;
    @Schema(description = "Название чертежа")
    @NotBlank(message = "drawing name should not be blank")
    private String name;

    @Override
    public String toString() {
        return "NewDrawingDto{" +
                "type='" + type + '\'' +
                ", number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
