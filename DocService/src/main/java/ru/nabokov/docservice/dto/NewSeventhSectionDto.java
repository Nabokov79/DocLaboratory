package ru.nabokov.docservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные нового раздела № 7")
public class NewSeventhSectionDto {

    @Schema(description = "Данные заголовка раздела")
    @NotNull(message = "section header should not be blank")
    private SectionHeaderDto sectionHeaderDto;
    @Schema(description = "Данные чертежей раздела")
    @NotNull(message = "drawings should not be blank")
    private List<NewDrawingDto> drawings;
}
