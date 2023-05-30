package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.client.passport_service.SurveyDto;
import ru.nabokov.docservice.dto.client.pattern_servicce.SubheadingSectionThreeDto;
import ru.nabokov.docservice.model.thirdSection.SurveysTable;
import ru.nabokov.docservice.repository.SurveysTableRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveysTableServiceImpl implements SurveysTableService {

    private final SurveysTableRepository repository;
    private final SurveysService surveysService;
    private final ColumnsHeadersService columnsHeadersService;
    private final StringBuilderServiceImpl stringBuilder;

    @Override
    public SurveysTable save(SubheadingSectionThreeDto subheadingDto, List<SurveyDto> surveys) {
        SurveysTable surveysTable = new SurveysTable();
        surveysTable.setHeading(stringBuilder.toStringSubheading(subheadingDto.getNumber(), subheadingDto.getHeading()));
        surveysTable.setColumnHeaders(columnsHeadersService.save(subheadingDto.getPatternTables().getColumnHeaders()));
        surveysTable.setSurveys(surveysService.save(repository.save(surveysTable), surveys));
        return surveysTable;
    }
}
