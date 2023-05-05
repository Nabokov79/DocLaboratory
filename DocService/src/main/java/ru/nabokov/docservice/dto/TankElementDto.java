package ru.nabokov.docservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class TankElementDto {

    private Long id;
    private String name;
    private List<PlaceDto> places;

    @Override
    public String toString() {
        return "TankElementDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", places=" + places +
                '}';
    }
}
