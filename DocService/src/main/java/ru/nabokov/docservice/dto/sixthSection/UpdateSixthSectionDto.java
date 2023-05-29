package ru.nabokov.docservice.dto.sixthSection;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.docservice.dto.client.pattern_servicce.HeaderDto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class UpdateSixthSectionDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id six section should not be blank")
    @Positive(message = "id six section must be positive")
    private Long id;
    @Schema(description = "Индентификатор отчета")
    @NotNull(message = "report id should not be blank")
    @Positive(message = "report id can only be positive")
    private Long reportId;
    @Schema(description = "Заголовок раздела")
    @NotNull(message = "header should not be blank")
    private HeaderDto header;
    @Schema(description = "Данные подразделов")
    @NotNull(message = "subheadings should not be blank")
    @NotEmpty(message = "subheadings should not be empty")
    private List<UpdateSubheadingsSixDto> subheadings;
}
