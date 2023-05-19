package ru.nabokov.docservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.docservice.dto.sixthSection.*;
import ru.nabokov.docservice.model.sixthSection.Recommendations;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecommendationsMapper {

    List<Recommendations> mapToNewRecommendationsDto(List<NewRecommendationsDto> recommendationsDto);

    List<Recommendations> mapToUpdateRecommendationsDto(List<UpdateRecommendationsDto> recommendationsDto);
}
