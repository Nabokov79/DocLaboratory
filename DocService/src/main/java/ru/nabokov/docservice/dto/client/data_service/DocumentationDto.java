package ru.nabokov.docservice.dto.client.data_service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class DocumentationDto {

    private Long id;
    private String view;
    private String number;
    private String title;
}
