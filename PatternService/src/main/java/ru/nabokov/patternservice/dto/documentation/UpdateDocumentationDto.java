package ru.nabokov.patternservice.dto.documentation;

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
@Schema(description = "Данные новой документации")
public class UpdateDocumentationDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id should not be blank")
    @Positive(message = "id can only be positive")
    private Long id;
    @Schema(description = "Заголовок протокола")
    @NotBlank(message = "type documentation should not be blank")
    private String type;
    @Schema(description = "Заголовок протокола")
    @NotBlank(message = "number documentation should not be blank")
    private String number;
    @Schema(description = "Заголовок протокола")
    @NotBlank(message = "title documentation should not be blank")
    private String title;
}
