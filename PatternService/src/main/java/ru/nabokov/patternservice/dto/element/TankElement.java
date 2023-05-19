package ru.nabokov.patternservice.dto.element;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokov.patternservice.model.Place;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TankElement {

    private Long id;
    private String name;
    private List<Place> places;

    @Override
    public String toString() {
        return "TankElement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", places=" + places +
                '}';
    }
}
