package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.passport.SurveyDto;
import ru.nabokov.docservice.model.Survey;
import ru.nabokov.docservice.model.SurveysTable;

import java.util.List;

public interface SurveysService {

    List<Survey> save(SurveysTable surveysTable, List<SurveyDto> surveysDto);
}
