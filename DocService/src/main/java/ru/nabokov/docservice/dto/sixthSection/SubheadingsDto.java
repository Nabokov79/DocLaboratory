package ru.nabokov.docservice.dto.sixthSection;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения рекомендаций")
public class SubheadingsDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Номер и название подраздела")
    private String heading;
    @Schema(description = "Рекомендации")
    private List<RecommendationsDto> recommendations;
}
