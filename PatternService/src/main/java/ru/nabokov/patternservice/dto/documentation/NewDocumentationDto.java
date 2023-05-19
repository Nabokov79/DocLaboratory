package ru.nabokov.patternservice.dto.documentation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные новой документации")
public class NewDocumentationDto {

    @Schema(description = "Заголовок протокола")
    @NotBlank(message = "type documentation should not be blank")
    private String type;
    @Schema(description = "Заголовок протокола")
    @NotBlank(message = "number documentation should not be blank")
    private String number;
    @Schema(description = "Заголовок протокола")
    @NotBlank(message = "title documentation should not be blank")
    private String title;

    @Override
    public String toString() {
        return "NewDocumentationDto{" +
                "type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
