package ru.nabokov.docservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NewReportDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id application should not be blank")
    @Positive(message = "id application must be positive")
    private Long applicationId;
    @Schema(description = "Данные чертежей")
    @NotNull(message = "drawings should not be blank")
    private List<NewDrawingDto> drawings;
}
