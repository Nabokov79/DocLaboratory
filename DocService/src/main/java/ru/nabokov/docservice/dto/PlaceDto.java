package ru.nabokov.docservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PlaceDto {

    private String place;

    @Override
    public String toString() {
        return "PlaceDto{" +
                "place='" + place + '\'' +
                '}';
    }
}
