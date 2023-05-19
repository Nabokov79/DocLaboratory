package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.client.passport.PassportDto;
import ru.nabokov.docservice.dto.client.pattern.PatternSectionThreeDto;
import ru.nabokov.docservice.dto.client.pattern.SubheadingThreeDto;
import ru.nabokov.docservice.exceptions.BadRequestException;
import ru.nabokov.docservice.model.thirdSection.ThirdSection;
import ru.nabokov.docservice.repository.ThirdSectionRepository;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ThirdSectionServiceImpl implements ThirdSectionService {

    private final ThirdSectionRepository repository;
    private final RepairsTableService repairsTableService;
    private final SurveysTableService surveysTableService;
    private final StringBuilderService stringBuilder;


    @Override
    public ThirdSection save(PatternSectionThreeDto patternSectionThree, PassportDto passport) {
        Map<Double, SubheadingThreeDto> subheadings = patternSectionThree.getSubheadings()
                .stream().collect(Collectors.toMap(SubheadingThreeDto::getNumber, s -> s));
        if (subheadings.size() > 2) {
            throw new BadRequestException(
                    String.format("Section three cannot have more than two subsections, subsections=%s"
                            , subheadings.size()));
        }
        ThirdSection section = new ThirdSection();
        section.setHeading(stringBuilder.toStringHeader(patternSectionThree.getHeader()));
        Double number = null;
        for (Double numbers : subheadings.keySet()) {
            if (number == null) {
                number = numbers;
            } else {
                if (number > numbers) {
                    section.setRepairsTable(repairsTableService.save(subheadings.get(number), passport.getRepairs()));
                    section.setSurveysTable(surveysTableService.save(subheadings.get(numbers), passport.getSurveys()));
                } else {
                    section.setRepairsTable(repairsTableService.save(subheadings.get(numbers), passport.getRepairs()));
                    section.setSurveysTable(surveysTableService.save(subheadings.get(number), passport.getSurveys()));
                }
            }
        }
        return repository.save(section);
    }
}
