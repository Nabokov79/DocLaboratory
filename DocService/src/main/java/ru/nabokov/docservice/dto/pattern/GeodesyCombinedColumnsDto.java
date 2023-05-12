package ru.nabokov.docservice.dto.pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class GeodesyCombinedColumnsDto {

    private Integer numberFirst;
    private Integer numberSecond;
    private String name;

    @Override
    public String toString() {
        return "GeodesyCombinedColumnsDto{" +
                "numberFirst=" + numberFirst +
                ", numberSecond=" + numberSecond +
                ", name='" + name + '\'' +
                '}';
    }
}
