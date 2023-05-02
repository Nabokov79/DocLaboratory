package ru.nabokov.patternservice.dto;

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
@Schema(description = "Данные нового титульного листа")
public class NewTextCenteredDto {

    @Schema(description = "Индентификатор типа объекта обследования")
    @NotNull(message = "type id should not be blank")
    @Positive(message = "type id can only be positive")
    private Long typeId;
    @Schema(description = "Название документа")
    @NotBlank(message = "report name should not be blank")
    private String reportName;
    @Schema(description = "Первая чать текста под названием документа")
    @NotBlank(message = "text first should not be blank")
    private String textFirst;
    @Schema(description = "Вторая чать текста под названием документа")
    @NotBlank(message = "text second should not be blank")
    private String textSecond;
    @Schema(description = "Текст перед подписью")
    @NotBlank(message = "signature should not be blank")
    private String signature;
    @Schema(description = "Название города, для нижней часть титульного листа")
    @NotBlank(message = "city name should not be blank")
    private String city;
}
