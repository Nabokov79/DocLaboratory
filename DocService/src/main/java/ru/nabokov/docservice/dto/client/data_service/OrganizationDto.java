package ru.nabokov.docservice.dto.client.data_service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class OrganizationDto {

    private Long id;
    private String type;
    private String name;
}
