package ru.nabokov.dataservice.dto.type;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.dataservice.dto.documentation.DocumentationDto;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные типа объекта")
public class TypeDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Тип объекта")
    private String name;
    @Schema(description = "Нормативная документация")
    private List<DocumentationDto> documentations;
}
