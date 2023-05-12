package ru.nabokov.docservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.docservice.dto.title.BuildingDto;
import ru.nabokov.docservice.dto.title.TypeDto;

@Setter
@Getter
@NoArgsConstructor
public class ObjectDataDto {

    private long id;
    private TypeDto type;
    private String model;
    private Integer number;
    private Integer volume;
    private String orientation;
    private String place;
    private BuildingDto building;

    @Override
    public String toString() {
        return "ObjectDataDto{" +
                "id=" + id +
                ", type=" + type +
                ", model='" + model + '\'' +
                ", number=" + number +
                ", volume=" + volume +
                ", orientation='" + orientation + '\'' +
                ", place='" + place + '\'' +
                ", building=" + building +
                '}';
    }
}
