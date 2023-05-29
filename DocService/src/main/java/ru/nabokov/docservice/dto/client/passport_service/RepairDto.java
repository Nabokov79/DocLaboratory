package ru.nabokov.docservice.dto.client.passport_service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.docservice.dto.client.data_service.ObjectDataDto;
import ru.nabokov.docservice.dto.client.data_service.OrganizationDto;

@Setter
@Getter
@AllArgsConstructor
public class RepairDto {

    private Long id;
    private ObjectDataDto objectData;
    private String date;
    private String description;
    private OrganizationDto organization;
}
