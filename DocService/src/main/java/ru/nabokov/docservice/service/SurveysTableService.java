package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.client.passport.SurveyDto;
import ru.nabokov.docservice.dto.client.pattern.SubheadingThreeDto;
import ru.nabokov.docservice.model.thirdSection.SurveysTable;

import java.util.List;

public interface SurveysTableService {

    SurveysTable save(SubheadingThreeDto subheadingDto, List<SurveyDto> surveys);
}
