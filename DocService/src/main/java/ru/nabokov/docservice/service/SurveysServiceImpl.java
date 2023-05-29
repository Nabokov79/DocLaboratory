package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.client.passport_service.SurveyDto;
import ru.nabokov.docservice.mapper.SectionMapper;
import ru.nabokov.docservice.model.thirdSection.Survey;
import ru.nabokov.docservice.model.thirdSection.SurveysTable;
import ru.nabokov.docservice.repository.SurveysRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveysServiceImpl implements SurveysService {

    private final SurveysRepository repository;
    private final SectionMapper sectionMapper;

    @Override
    public List<Survey> save(SurveysTable surveysTable, List<SurveyDto> surveysDto) {
        List<Survey> surveys = new ArrayList<>();
        for (SurveyDto surveyDto : surveysDto) {
            Survey survey = sectionMapper.mapToSurveys(surveyDto);
            survey.setSurveysTable(surveysTable);
            surveys.add(survey);
        }
        return repository.saveAll(surveys);
    }
}
