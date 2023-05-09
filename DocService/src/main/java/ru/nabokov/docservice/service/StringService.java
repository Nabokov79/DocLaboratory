package ru.nabokov.docservice.service;

import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.title.AddressDto;

@Service
public class StringService {

    private static final String HOUSE = "д.";
    private static final String BUILDING = "к.";
    private static final String LETTER = "лит.";

    public String getStringAddress(AddressDto addressDto) {
        if (addressDto.getBuildingNumber() != null) {
            return String.join(", ", addressDto.getStreet(),
                    String.join("", HOUSE, String.valueOf(addressDto.getHouseNumber())),
                    String.join("",BUILDING, String.valueOf(addressDto.getBuildingNumber())));
        }
        if (addressDto.getLetter() != null) {
            return String.join(", ", addressDto.getStreet(),
                    String.join("", HOUSE, String.valueOf(addressDto.getHouseNumber())),
                    String.join("",LETTER, addressDto.getLetter()));
        }
        if (addressDto.getBuildingNumber() != null && addressDto.getLetter() != null) {
            return String.join(", ", addressDto.getStreet(),
                    String.join("", HOUSE, String.valueOf(addressDto.getHouseNumber())),
                    String.join("",BUILDING, String.valueOf(addressDto.getBuildingNumber())),
                    String.join("",LETTER, addressDto.getLetter()));
        } else {
            return String.join(", ", addressDto.getStreet(),
                    String.join("", HOUSE, String.valueOf(addressDto.getHouseNumber())));
        }
    }
}
