package ru.nabokov.docservice.dto.client.passport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.docservice.dto.ObjectDataDto;
import ru.nabokov.docservice.dto.OrganizationDto;

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
