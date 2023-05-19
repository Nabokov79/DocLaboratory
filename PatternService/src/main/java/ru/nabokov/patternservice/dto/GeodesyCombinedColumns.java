package ru.nabokov.patternservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GeodesyCombinedColumns {

    private long id;
    private Integer numberFirst;
    private Integer numberSecond;
    private String name;

    @Override
    public String toString() {
        return "GeodesyCombinedColumns{" +
                "id=" + id +
                ", numberFirst=" + numberFirst +
                ", numberSecond=" + numberSecond +
                ", name='" + name + '\'' +
                '}';
    }
}
