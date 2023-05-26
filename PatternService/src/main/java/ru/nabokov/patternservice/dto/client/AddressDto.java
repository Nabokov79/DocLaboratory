package ru.nabokov.patternservice.dto.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private Long id;
    private CityDto city;
    private String street;
    private Integer houseNumber;
    private Integer buildingNumber;
    private String letter;
}
