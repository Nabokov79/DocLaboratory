package ru.nabokov.docservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class TextCenteredDto {

    private String reportName;
    private String textFirst;
    private String object;
    private String textSecond;
    private String signature;
    private String city;
    private String year;

    @Override
    public String toString() {
        return "TextCenteredDto{" +
                "reportName='" + reportName + '\'' +
                ", textFirst='" + textFirst + '\'' +
                ", object='" + object + '\'' +
                ", textSecond='" + textSecond + '\'' +
                ", signature='" + signature + '\'' +
                ", city='" + city + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
