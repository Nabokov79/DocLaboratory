package ru.nabokov.dataservice.dto.type;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные нового типа объекта")
public class NewTypeDto {

    @Schema(description = "Тип объекта")
    @NotBlank(message = "name type should not be blank")
    private String name;
    @Schema(description = "Индентификаторы нормативной документации")
    private List<Long> documentationIds;
}
