package ru.nabokov.patternservice.dto.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class License {

    private long id;
    private String document;
    private Organization organization;
    private String number;
    private LocalDate date;
}
