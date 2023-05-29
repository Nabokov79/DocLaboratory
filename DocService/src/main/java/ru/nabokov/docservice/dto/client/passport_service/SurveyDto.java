package ru.nabokov.docservice.dto.client.passport_service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.docservice.dto.client.data_service.ObjectDataDto;
import ru.nabokov.docservice.dto.client.data_service.OrganizationDto;

@Setter
@Getter
@AllArgsConstructor
public class SurveyDto {

    private Long id;
    private ObjectDataDto objectData;
    private String date;
    private String survey;
    private String number;
    private OrganizationDto organization;
}
