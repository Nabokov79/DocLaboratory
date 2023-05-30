package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.client.passport_service.SurveyDto;
import ru.nabokov.docservice.dto.client.pattern_servicce.SubheadingSectionThreeDto;
import ru.nabokov.docservice.model.thirdSection.SurveysTable;

import java.util.List;

public interface SurveysTableService {

    SurveysTable save(SubheadingSectionThreeDto subheadingDto, List<SurveyDto> surveys);
}
