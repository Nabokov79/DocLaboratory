package ru.nabokov.dataservice.dto.element;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.dataservice.dto.defect.NewDefectDto;
import ru.nabokov.dataservice.dto.place.NewPlaceDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные нового элемента таблицы")
public class NewElementDto {

    @Schema(description = "Название элемента")
    @NotBlank(message = "name should not be blank")
    private String name;
    @Schema(description = "Место замера на элементе")
    private List<NewPlaceDto> places;
    @Schema(description = "Список дефектов элемента")
    @NotNull(message = "defects should not be blank")
    @NotEmpty(message = "defects can only be positive")
    private List<NewDefectDto> defects;
}
