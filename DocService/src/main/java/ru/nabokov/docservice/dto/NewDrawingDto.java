package ru.nabokov.docservice.dto;

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
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные чертежей к отчету")
public class NewDrawingDto {

    @Schema(description = "Тип чертежа")
    @NotBlank(message = "heading should not be blank")
    private String type;
    @Schema(description = "Номер чертежа")
    @NotNull(message = "number should not be blank")
    @Positive(message = "number must be positive")
    private Integer number;
    @Schema(description = "Название чертежа")
    @NotBlank(message = "heading should not be blank")
    private String name;
    @Schema(description = "Колличество листов чертежа")
    @NotNull(message = "number should not be blank")
    @Positive(message = "number must be positive")
    private Integer count;
}
