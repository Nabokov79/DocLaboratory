package ru.nabokov.docservice.dto.client.passport_service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CharacteristicDto {

    private Long id;
    private Double number;
    private String heading;
    private String meaning;
}
