package ru.nabokov.passportservice.dto.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AuthorDto {

    private Long id;
    private String name;
}
