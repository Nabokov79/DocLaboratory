package ru.nabokov.docservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.docservice.dto.client.pattern_servicce.HeaderDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные нового раздела № 7")
public class NewSeventhSectionDto {

    @Schema(description = "Индентификатор отчета")
    @NotNull(message = "report id should not be blank")
    @Positive(message = "report id can only be positive")
    private Long reportId;
    @Schema(description = "Данные чертежей раздела")
    @NotNull(message = "drawings should not be blank")
    private List<NewDrawingDto> drawings;
}
