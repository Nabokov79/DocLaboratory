package ru.nabokov.dataservice.dto.documentation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные нового автора проекта")
public class NewDocumentationDto {

    @Schema(description = "Вид документа")
    @NotBlank(message = "view should not be blank")
    private String view;
    @Schema(description = "Номер документа")
    @NotBlank(message = "number should not be blank")
    private String number;
    @Schema(description = "Заголовок документа")
    @NotBlank(message = "title should not be blank")
    private String title;
}
