package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.recommendation.NewRecommendationDto;
import ru.nabokov.patternservice.dto.recommendation.UpdateRecommendationDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.RecommendationMapper;
import ru.nabokov.patternservice.model.Recommendation;
import ru.nabokov.patternservice.model.Subheading;
import ru.nabokov.patternservice.repository.RecommendationRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {

    private final RecommendationRepository repository;
    private final RecommendationMapper mapper;

    @Override
    public void save(Subheading subheading, List<NewRecommendationDto> recommendationsDto) {
        List<Recommendation> recommendations = mapper.mapToNewRecommendation(recommendationsDto);
        for (Recommendation recommendation : recommendations) {
            recommendation.setSubheading(subheading);
        }
        repository.saveAll(recommendations);
    }

    @Override
    public void update(Subheading subheading, List<UpdateRecommendationDto> recommendationsDto) {
        validateIds(recommendationsDto.stream().map(UpdateRecommendationDto::getId).toList());
        List<Recommendation> recommendations = mapper.mapToUpdateRecommendation(recommendationsDto);
        for (Recommendation recommendation : recommendations) {
            recommendation.setSubheading(subheading);
        }
        repository.saveAll(recommendations);
    }

    private void validateIds(List<Long> ids) {
        Map<Long, Recommendation> recommendations = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(Recommendation::getId, d -> d));
        if (recommendations.size() != ids.size() || recommendations.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(recommendations.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("recommendations with ids= %s not found", ids));
        }
    }
}
