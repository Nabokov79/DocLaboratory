package ru.nabokov.docservice.service;

import ru.nabokov.docservice.dto.sixthSection.NewRecommendationsDto;
import ru.nabokov.docservice.dto.sixthSection.UpdateRecommendationsDto;
import ru.nabokov.docservice.model.sixthSection.Recommendations;
import java.util.List;

public interface RecommendationsService {

    List<Recommendations> save(List<NewRecommendationsDto> recommendationsDto);

    List<Recommendations> update(List<UpdateRecommendationsDto> recommendationsDto);
}
