package ru.nabokov.patternservice.dto.element;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.patternservice.dto.defect.NewDefectDto;
import ru.nabokov.patternservice.dto.place.NewPlaceDto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные нового элемента таблицы")
public class NewElementDto {

    @Schema(description = "Номер строки с элементом")
    @NotNull(message = "item should not be blank")
    @Positive(message = "item can only be positive")
    private Integer item;
    @Schema(description = "Название элемента")
    @NotBlank(message = "name should not be blank")
    private String name;
    @Schema(description = "Место замера на элементе")
    private List<NewPlaceDto> places;
    @Schema(description = "Список дефектов элемента")
    private List<NewDefectDto> defects;
}
