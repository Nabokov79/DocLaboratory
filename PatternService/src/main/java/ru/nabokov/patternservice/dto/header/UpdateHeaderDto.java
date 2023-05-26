package ru.nabokov.patternservice.dto.header;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения заголовка раздела")
public class UpdateHeaderDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "header id should not be blank")
    @Positive(message = "header id can only be positive")
    private Long id;
    @Schema(description = "Номер раздела")
    @NotNull(message = "number should not be blank")
    @Positive(message = "number can only be positive")
    private Integer number;
    @Schema(description = "Заголовок раздела")
    @NotBlank(message = "heading should not be blank")
    private String heading;
}
