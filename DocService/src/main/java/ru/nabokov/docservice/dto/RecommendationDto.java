package ru.nabokov.docservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class RecommendationDto {

    private Long id;
    private String recommendation;
}
