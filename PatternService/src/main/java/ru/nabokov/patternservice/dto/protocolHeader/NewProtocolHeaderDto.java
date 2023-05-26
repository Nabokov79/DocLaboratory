package ru.nabokov.patternservice.dto.protocolHeader;

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
@Schema(description = "Данные нового шаблона протокола")
public class NewProtocolHeaderDto {

    @Schema(description = "Номер протокола")
    @NotNull(message = "number should not be blank")
    @Positive(message = "number can only be positive")
    private Integer number;
    @Schema(description = "Тип документа")
    @NotBlank(message = "document should not be blank")
    private String document;
    @Schema(description = "Название документа")
    @NotBlank(message = "document should not be blank")
    private String name;
    @Schema(description = "Текст под заголовком документа")
    @NotBlank(message = "document should not be blank")
    private String text;
    @Schema(description = "Заголовок обзаца средств измерений")
    @NotBlank(message = "document should not be blank")
    private String headerMeasurements;
    @Schema(description = "Текст указания на раположения мест измерений(контроля)")
    @NotBlank(message = "document should not be blank")
    private String location;
    @Schema(description = "Текст указания погрешности измерения")
    @NotBlank(message = "document should not be blank")
    private String admissibility;
}