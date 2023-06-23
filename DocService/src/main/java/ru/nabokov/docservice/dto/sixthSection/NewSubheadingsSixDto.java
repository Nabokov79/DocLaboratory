package ru.nabokov.docservice.dto.sixthSection;

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
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Данные новых подзаголовков раздела")
public class NewSubheadingsSixDto {

    @Schema(description = "Номер подраздела")
    @NotNull(message = "number should not be blank")
    @Positive(message = "number must be positive")
    private Double number;
    @Schema(description = "Разрешенный срок эксплуатации")
    private Integer year;
    @Schema(description = "Рекомендации")
    private List<NewRecommendationsDto> recommendations;
}
