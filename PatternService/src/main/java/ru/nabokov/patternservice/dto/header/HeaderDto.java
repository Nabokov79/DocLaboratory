package ru.nabokov.patternservice.dto.header;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные заголовка раздела")
public class HeaderDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Номер раздела")
    private Integer number;
    @Schema(description = "Заголовок раздела")
    private String heading;
}
