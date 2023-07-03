package ru.nabokov.dataservice.dto.element;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.dataservice.dto.defect.UpdateDefectDto;
import ru.nabokov.dataservice.dto.place.UpdatePlaceDto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения информации о элементе таблицы")
public class UpdateElementDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id should not be blank")
    @Positive(message = "id can only be positive")
    private Long id;
    @Schema(description = "Название элемента")
    @NotBlank(message = "name should not be blank")
    private String name;
    @Schema(description = "Место замера на элементе")
    private List<UpdatePlaceDto> places;
    @Schema(description = "Список дефектов элемента")
    @NotNull(message = "defects should not be blank")
    @NotEmpty(message = "defects can only be positive")
    private List<UpdateDefectDto> defects;
}
