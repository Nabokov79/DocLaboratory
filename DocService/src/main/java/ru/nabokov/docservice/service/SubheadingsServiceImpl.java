package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.client.data_service.ObjectDataDto;
import ru.nabokov.docservice.dto.client.pattern_servicce.SubheadingDto;
import ru.nabokov.docservice.dto.sixthSection.NewSubheadingsSixDto;
import ru.nabokov.docservice.model.sixthSection.SixthSection;
import ru.nabokov.docservice.model.sixthSection.SubheadingSection;
import ru.nabokov.docservice.repository.SubheadingsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubheadingsServiceImpl implements SubheadingsService {

    private final SubheadingsRepository repository;
    private final RecommendationsService recommendationsService;
    private final StringBuilderServiceImpl stringBuilder;

    @Override
    public void save(ObjectDataDto objectData, SixthSection section, List<SubheadingDto> subheadings, List<NewSubheadingsSixDto> subheadingsDto) {
        Map<Double,SubheadingDto> subheadingsMap = subheadings.stream().collect(Collectors.toMap(SubheadingDto::getNumber, s -> s));
        List<SubheadingSection> subheadingsDb = new ArrayList<>();
        for (NewSubheadingsSixDto newSubheading : subheadingsDto) {
            SubheadingSection subheading = new SubheadingSection();
            subheading.setSubheading(stringBuilder.toStringSubheading(newSubheading.getNumber()
                                                                    , subheadingsMap.get(newSubheading.getNumber()).getHeading()));
            subheading.setConclusion(stringBuilder.toStringConclusion(objectData.getType()
                                                                    , objectData.getNumber()
                                                                    , subheadingsMap.get(newSubheading.getNumber()).getConclusions().getIsNotDefect()));
            subheading.setRecommendations(recommendationsService.save(newSubheading.getRecommendations()));
            subheading.setSixthSection(section);
            subheadingsDb.add(subheading);
        }
        repository.saveAll(subheadingsDb);
    }
}
