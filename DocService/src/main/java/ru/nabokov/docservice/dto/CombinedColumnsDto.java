package ru.nabokov.docservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CombinedColumnsDto {

    private Integer numberFirst;
    private String nameFirst;
    private Integer numberSecond;
    private String nameSecond;
    private String name;

    @Override
    public String toString() {
        return "CombinedColumnsDto{" +
                "numberFirst=" + numberFirst +
                ", nameFirst='" + nameFirst + '\'' +
                ", numberSecond=" + numberSecond +
                ", nameSecond='" + nameSecond + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
