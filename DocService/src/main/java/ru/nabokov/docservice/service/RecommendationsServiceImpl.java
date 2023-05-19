package ru.nabokov.docservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.docservice.dto.sixthSection.NewRecommendationsDto;
import ru.nabokov.docservice.dto.sixthSection.UpdateRecommendationsDto;
import ru.nabokov.docservice.exceptions.NotFoundException;
import ru.nabokov.docservice.mapper.RecommendationsMapper;
import ru.nabokov.docservice.model.sixthSection.Recommendations;
import ru.nabokov.docservice.repository.RecommendationsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecommendationsServiceImpl implements RecommendationsService {

    private final RecommendationsRepository repository;
    private final RecommendationsMapper mapper;

    @Override
    public List<Recommendations> save(List<NewRecommendationsDto> recommendationsDto) {
        List<Recommendations> recommendations = mapper.mapToNewRecommendationsDto(recommendationsDto);
        recommendations.addAll(
           repository.findAllByRecommendation(recommendations.stream().map(Recommendations::getRecommendation).toList())
        );
        return repository.saveAll(recommendations.stream().distinct().toList());
    }

    @Override
    public List<Recommendations> update(List<UpdateRecommendationsDto> recommendationsDto) {
        validateIds(recommendationsDto.stream().map(UpdateRecommendationsDto::getId).toList());
        List<Recommendations> recommendations = mapper.mapToUpdateRecommendationsDto(recommendationsDto);
        return repository.saveAll(recommendations.stream().distinct().toList());
    }

    private void validateIds(List<Long> ids) {
        Map<Long, Recommendations> recommendations = repository.findAllById((ids))
                .stream().collect(Collectors.toMap(Recommendations::getId, d -> d));
        if (recommendations.size() != ids.size() || recommendations.isEmpty()) {
            List<Long> idsDb = new ArrayList<>(recommendations.keySet());
            ids = ids.stream().filter(e -> !idsDb.contains(e)).collect(Collectors.toList());
            throw new NotFoundException(String.format("recommendations with ids= %s not found", ids));
        }
    }
}
