package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.passport.PassportDto;
import ru.nabokov.docservice.dto.pattern.PatternSectionThreeDto;
import ru.nabokov.docservice.dto.pattern.SubheadingThreeDto;
import ru.nabokov.docservice.mapper.SectionMapper;
import ru.nabokov.docservice.model.RepairsTable;
import ru.nabokov.docservice.model.SurveysTable;
import ru.nabokov.docservice.model.ThirdSection;
import ru.nabokov.docservice.repository.ThirdSectionRepository;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ThirdSectionServiceImpl implements ThirdSectionService {

    private final ThirdSectionRepository repository;
    private final SectionMapper sectionMapper;

    @Override
    public ThirdSection save(PatternSectionThreeDto patternSectionThree, PassportDto passport) {
        ThirdSection section = new ThirdSection();
        Map<Double, SubheadingThreeDto> subheadings = patternSectionThree.getSubheadings()
                                             .stream().collect(Collectors.toMap(SubheadingThreeDto::getNumber, s -> s));
        RepairsTable repairsTable = new RepairsTable();
        SurveysTable surveysTable = new SurveysTable();
        Double number;
        return null;
    }
}
