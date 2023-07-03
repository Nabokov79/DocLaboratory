package ru.nabokov.passportservice.service.passport;

import ru.nabokov.passportservice.dto.survey.NewSurveyDto;
import ru.nabokov.passportservice.dto.survey.UpdateSurveyDto;
import ru.nabokov.passportservice.model.passport.Survey;

import java.util.List;

public interface SurveyService {

    List<Survey> save(List<NewSurveyDto> surveysDto);

    List<Survey> update(List<UpdateSurveyDto> surveysDto);
}
