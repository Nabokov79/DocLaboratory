package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.client.passport.SurveyDto;
import ru.nabokov.docservice.dto.client.pattern.SubheadingThreeDto;
import ru.nabokov.docservice.model.thirdSection.SurveysTable;
import ru.nabokov.docservice.repository.SurveysTableRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveysTableServiceImpl implements SurveysTableService {

    private final SurveysTableRepository repository;
    private final SurveysService surveysService;
    private final ColumnsHeadersService columnsHeadersService;
    private final StringBuilderService stringBuilder;

    @Override
    public SurveysTable save(SubheadingThreeDto subheadingDto, List<SurveyDto> surveys) {
        SurveysTable surveysTable = new SurveysTable();
        surveysTable.setHeading(stringBuilder.toStringSubheading(subheadingDto.getNumber(), subheadingDto.getHeading()));
        surveysTable.setColumnHeaders(columnsHeadersService.save(subheadingDto.getColumnHeaders()));
        surveysTable.setSurveys(surveysService.save(repository.save(surveysTable), surveys));
        return null;
    }
}
