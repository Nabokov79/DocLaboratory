package ru.nabokov.patternservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class SubheadingDto {

    private long id;
    private Double number;
    private String heading;
    private String text;
}
