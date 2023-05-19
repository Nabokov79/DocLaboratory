package ru.nabokov.docservice.dto.client.title;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AddressDto {

    private CityDto city;
    private String street;
    private Integer houseNumber;
    private Integer buildingNumber;
    private String letter;

    @Override
    public String toString() {
        return "AddressDto{" +
                "city=" + city +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", buildingNumber=" + buildingNumber +
                ", letter='" + letter + '\'' +
                '}';
    }
}
