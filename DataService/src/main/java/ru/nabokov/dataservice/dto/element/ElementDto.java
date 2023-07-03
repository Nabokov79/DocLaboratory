package ru.nabokov.dataservice.dto.element;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.dataservice.dto.defect.DefectDto;
import ru.nabokov.dataservice.dto.place.PlaceDto;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные элементе таблицы")
public class ElementDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Название элемента")
    private String name;
    @Schema(description = "Место замера на элементе")
    private List<PlaceDto> places;
    @Schema(description = "Список дефектов элемента")
    private List<DefectDto> defects;
}
