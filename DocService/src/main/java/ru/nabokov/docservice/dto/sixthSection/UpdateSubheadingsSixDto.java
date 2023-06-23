package ru.nabokov.docservice.dto.sixthSection;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения рекомендаций")
public class UpdateSubheadingsSixDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "id subheadings six section should not be blank")
    @Positive(message = "id subheadings six section must be positive")
    private Long id;
    @Schema(description = "Номер подраздела")
    @NotNull(message = "number should not be blank")
    @Positive(message = "number must be positive")
    private Double number;
    @Schema(description = "Разрешенный срок эксплуатации")
    private Integer year;
    @Schema(description = "Рекомендации")
    private List<UpdateRecommendationsDto> recommendations;
}
