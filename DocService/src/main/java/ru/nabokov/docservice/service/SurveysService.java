package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.client.passport.SurveyDto;
import ru.nabokov.docservice.model.thirdSection.Survey;
import ru.nabokov.docservice.model.thirdSection.SurveysTable;

import java.util.List;

public interface SurveysService {

    List<Survey> save(SurveysTable surveysTable, List<SurveyDto> surveysDto);
}
