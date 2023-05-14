package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.passport.SurveyDto;
import ru.nabokov.docservice.dto.pattern.SubheadingThreeDto;
import ru.nabokov.docservice.model.SurveysTable;

import java.util.List;

public interface SurveysTableService {

    SurveysTable save(SubheadingThreeDto subheadingDto, List<SurveyDto> surveys);
}
