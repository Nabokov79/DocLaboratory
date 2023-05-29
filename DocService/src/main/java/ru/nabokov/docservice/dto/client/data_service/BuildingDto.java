package ru.nabokov.docservice.dto.client.data_service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BuildingDto {

    private long id;
    private AddressDto address;
    private String building;
    private String branch;
    private String login;

    @Override
    public String toString() {
        return "BuildingDto{" +
                "id=" + id +
                ", address=" + address +
                ", building='" + building + '\'' +
                ", branch='" + branch + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
