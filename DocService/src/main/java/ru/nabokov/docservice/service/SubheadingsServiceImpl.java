package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.ObjectDataDto;
import ru.nabokov.docservice.dto.sixthSection.NewSubheadingsSixDto;
import ru.nabokov.docservice.dto.sixthSection.UpdateSubheadingsSixDto;
import ru.nabokov.docservice.model.sixthSection.SixthSection;
import ru.nabokov.docservice.model.sixthSection.SubheadingSection;
import ru.nabokov.docservice.repository.SubheadingsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubheadingsServiceImpl implements SubheadingsService {

    private final SubheadingsRepository repository;
    private final RecommendationsService recommendationsService;
    private final StringBuilderService stringBuilder;

    @Override
    public void save(SixthSection section, ObjectDataDto objectData, List<NewSubheadingsSixDto> subheadingsDto) {
        List<SubheadingSection> subheadings = new ArrayList<>();
        for (NewSubheadingsSixDto newSubheading : subheadingsDto) {
            SubheadingSection subheading = new SubheadingSection();
            subheading.setSubheading(stringBuilder.toStringSubheading(newSubheading.getNumber()
                                                                    , newSubheading.getHeading()));
            subheading.setConclusion(stringBuilder.toStringConclusion(objectData.getType()
                                                                    , objectData.getNumber()
                                                                    , newSubheading.getConclusion()));
            subheading.setRecommendations(recommendationsService.save(newSubheading.getRecommendations()));
            subheading.setSixthSection(section);
            subheadings.add(subheading);
        }
        repository.saveAll(subheadings);
    }

    @Override
    public void update(SixthSection section, ObjectDataDto objectData,  List<UpdateSubheadingsSixDto> subheadingsDto) {

    }
}
