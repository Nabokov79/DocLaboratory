package ru.nabokov.passportservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.passportservice.dto.survey.NewSurveyDto;
import ru.nabokov.passportservice.dto.survey.UpdateSurveyDto;
import ru.nabokov.passportservice.exceptions.NotFoundException;
import ru.nabokov.passportservice.mapper.SurveyMapper;
import ru.nabokov.passportservice.model.Survey;
import ru.nabokov.passportservice.repository.SurveyRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository repository;
    private final SurveyMapper mapper;

    @Override
    public List<Survey> save(List<NewSurveyDto> surveysDto) {
        return repository.saveAll(mapper.mapToNewSurveys(surveysDto));
    }

    @Override
    public List<Survey> update(List<UpdateSurveyDto> surveysDto) {
        validateIds(surveysDto.stream().map(UpdateSurveyDto::getId).toList());
        return repository.saveAll(mapper.mapToUpdateSurveys(surveysDto));
    }

    private void validateIds(List<Long> ids) {
        Map<Long, Survey> surveys = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(Survey::getId, d -> d));
        if (surveys.size() != ids.size() || surveys.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(surveys.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("surveys with ids= %s not found", ids));
        }
    }
}
