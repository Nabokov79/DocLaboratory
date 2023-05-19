package ru.nabokov.patternservice.dto.documentation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные нормативных документов")
public class DocumentationDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Заголовок протокола")
    private String type;
    @Schema(description = "Заголовок протокола")
    private String number;
    @Schema(description = "Заголовок протокола")
    private String title;

    @Override
    public String toString() {
        return "DocumentationDto{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
