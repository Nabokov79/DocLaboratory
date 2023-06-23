package ru.nabokov.passportservice.dto.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AddressDto {

    private long id;
    private CityDto city;
    private String street;
    private Integer houseNumber;
    private Integer buildingNumber;
    private String letter;
}
