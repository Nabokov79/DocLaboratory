package ru.nabokov.dataservice.dto.address;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.dataservice.model.City;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные адреса")
public class AddressDto {

    @Schema(description = "Индентификатор города")
    private Long id;
    @Schema(description = "Населенный пункт")
    private City city;
    @Schema(description = "Название улицы")
    private String street;
    @Schema(description = "Номер дома")
    private Integer houseNumber;
    @Schema(description = "Номер корпуса дома")
    private Integer buildingNumber;
    @Schema(description = "Литера дома")
    private String letter;
}
