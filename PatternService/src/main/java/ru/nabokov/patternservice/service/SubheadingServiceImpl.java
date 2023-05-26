package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.subheading.NewSubheadingDto;
import ru.nabokov.patternservice.dto.subheading.UpdateSubheadingDto;
import ru.nabokov.patternservice.dto.recommendation.NewRecommendationDto;
import ru.nabokov.patternservice.dto.recommendation.UpdateRecommendationDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.SubheadingMapper;
import ru.nabokov.patternservice.model.Subheading;
import ru.nabokov.patternservice.repository.SubheadingRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubheadingServiceImpl implements SubheadingService {

    private final SubheadingRepository repository;
    private final SubheadingMapper mapper;
    private final RecommendationService recommendationService;

    @Override
    public List<Subheading> save(List<NewSubheadingDto> subheadingsDto) {
        List<String> numbers = subheadingsDto.stream()
                                             .filter(s -> s.getRecommendations() != null)
                                             .map(NewSubheadingDto::getNumber)
                                             .toList();
        Map<String, Subheading> subheadings = repository.saveAll(mapper.mapToNewSubheadings(subheadingsDto)).stream()
                                                          .collect(Collectors.toMap(Subheading::getNumber, s -> s));
        Map<String, List<NewRecommendationDto>> recommendations = subheadingsDto
                                                                .stream()
                                                                .filter(s -> s.getRecommendations() != null)
                                                                .collect(Collectors.toMap(NewSubheadingDto::getNumber
                                                                        , NewSubheadingDto::getRecommendations));
        for (String number : numbers) {
            List<NewRecommendationDto> recommendationsDto = recommendations.get(number);
            if (recommendationsDto != null) {
                recommendationService.save(subheadings.get(number), recommendations.get(number));
            }
        }
        return new ArrayList<>(subheadings.values());
    }

    @Override
    public List<Subheading> update(List<UpdateSubheadingDto> subheadingsDto) {
        validateIds(subheadingsDto.stream().map(UpdateSubheadingDto::getId).toList());
        List<String> numbers = subheadingsDto.stream()
                                             .filter(s -> s.getRecommendations() != null)
                                             .map(UpdateSubheadingDto::getNumber)
                                             .toList();
        Map<String, Subheading> subheadings = repository.saveAll(mapper.mapToUpdateSubheadings(subheadingsDto)).stream()
                                                        .collect(Collectors.toMap(Subheading::getNumber, s -> s));
        Map<String, List<UpdateRecommendationDto>> recommendations = subheadingsDto
                                                            .stream()
                                                            .filter(s -> s.getRecommendations() != null)
                                                            .collect(Collectors.toMap(UpdateSubheadingDto::getNumber
                                                                    , UpdateSubheadingDto::getRecommendations));
        for (String number : numbers) {
            List<UpdateRecommendationDto> recommendationsDto = recommendations.get(number);
            if (recommendationsDto != null) {
                recommendationService.update(subheadings.get(number), recommendations.get(number));
            }
        }
        return new ArrayList<>(subheadings.values());
    }

    private void validateIds(List<Long> ids) {
        Map<Long, Subheading> subheadings = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(Subheading::getId, subheading -> subheading));
        if (subheadings.size() != ids.size() || subheadings.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(subheadings.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("subheadings with ids= %s not found", ids));
        }
    }
}
