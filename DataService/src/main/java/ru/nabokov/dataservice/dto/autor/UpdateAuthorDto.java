package ru.nabokov.dataservice.dto.autor;

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
@Schema(description = "Данные для изменения информации о авторе проекта")
public class UpdateAuthorDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id author should not be blank")
    @Positive(message = "id author must be positive")
    private Long id;
    @Schema(description = "Автор проекта")
    @NotBlank(message = "name author should not be blank")
    private String name;
}
