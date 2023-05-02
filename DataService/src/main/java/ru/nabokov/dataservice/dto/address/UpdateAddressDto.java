package ru.nabokov.dataservice.dto.address;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@Schema(description = "Данные для изменения информации о адресе")
public class UpdateAddressDto {

    @Schema(description = "Индентификатор")
    @NotNull(message = "address id should not be blank")
    @Positive(message = "address id can only be positive")
    private Long id;
    @Schema(description = "Индентификатор населенного пункта")
    @NotNull(message = "city id should not be blank")
    @Positive(message = "city id can only be positive")
    private Long cityId;
    @Schema(description = "Название улицы")
    @NotBlank(message = "street name should not be blank")
    private String street;
    @Schema(description = "Номер дома")
    @NotNull(message = "house number should not be blank")
    @Positive(message = "house number can only be positive")
    private Integer houseNumber;
    @Schema(description = "Номер корпуса дома")
    @Positive(message = "building number can only be positive")
    private Integer buildingNumber;
    @Schema(description = "Литера дома")
    private String letter;
}
