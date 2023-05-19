package ru.nabokov.patternservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.patternservice.dto.recommendation.NewRecommendationDto;
import ru.nabokov.patternservice.dto.recommendation.UpdateRecommendationDto;
import ru.nabokov.patternservice.model.Recommendation;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecommendationMapper {

    List<Recommendation> mapToNewRecommendation(List<NewRecommendationDto> recommendations);

    List<Recommendation> mapToUpdateRecommendation(List<UpdateRecommendationDto> recommendations);
}
