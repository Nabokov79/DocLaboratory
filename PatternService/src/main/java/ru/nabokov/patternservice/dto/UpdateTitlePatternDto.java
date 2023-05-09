package ru.nabokov.patternservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.model.TitlePageData;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения информации в шаблоне титульного листа")
public class UpdateTitlePatternDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id should not be blank")
    @Positive(message = "id can only be positive")
    private Long id;
    @Schema(description = "Тип объекта шаблона")
    @NotBlank(message = "template object type should not be blank")
    private String templateObjectType;
    @Schema(description = "Текст по центру титульного листа")
    @NotNull(message = "text centered should not be blank")
    private TitlePageData titlePageData;
}
