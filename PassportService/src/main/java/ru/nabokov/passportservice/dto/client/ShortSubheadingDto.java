package ru.nabokov.passportservice.dto.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ShortSubheadingDto {

    private Long id;
    private Double number;
    private String heading;
}
