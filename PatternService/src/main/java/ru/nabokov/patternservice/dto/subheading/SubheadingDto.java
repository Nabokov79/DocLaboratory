package ru.nabokov.patternservice.dto.subheading;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные подрраздела разделов #: № 1, 2, 4, 5, 6")
public class SubheadingDto {

    @Schema(description = "Индентификатор")
    private Long id;
    @Schema(description = "Номер подраздела")
    private String number;
    @Schema(description = "Заголовок подраздела")
    private String heading;

    @Override
    public String toString() {
        return "SubheadingDto{" +
                "id=" + id +
                ", number=" + number +
                ", heading='" + heading + '\'' +
                '}';
    }
}
