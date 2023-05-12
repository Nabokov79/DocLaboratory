package ru.nabokov.docservice.dto.passport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nabokov.docservice.dto.ObjectDataDto;
import ru.nabokov.docservice.dto.OrganizationDto;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
public class SurveyDto {

    private Long id;
    private ObjectDataDto objectData;
    private LocalDate date;
    private String survey;
    private String number;
    private OrganizationDto organization;
}
