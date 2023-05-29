package ru.nabokov.docservice.dto.client.data_service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CityDto {

    private Long id;
    private String name;

    @Override
    public String toString() {
        return "CityDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
