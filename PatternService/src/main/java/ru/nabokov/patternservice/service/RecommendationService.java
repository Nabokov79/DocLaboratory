package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.dto.recommendation.NewRecommendationDto;
import ru.nabokov.patternservice.dto.recommendation.UpdateRecommendationDto;
import ru.nabokov.patternservice.model.Subheading;
import java.util.List;

public interface RecommendationService {

    void save(Subheading subheading, List<NewRecommendationDto> recommendationsDto);

    void update(Subheading subheading, List<UpdateRecommendationDto> recommendationsDto);
}
