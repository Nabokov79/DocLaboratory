package ru.nabokov.patternservice.service.protocol;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.dto.conclusion.NewPatternConclusionDto;
import ru.nabokov.patternservice.dto.conclusion.UpdatePatternConclusionDto;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.mapper.PatternConclusionMapper;
import ru.nabokov.patternservice.model.PatternConclusion;
import ru.nabokov.patternservice.repository.PatternConclusionRepository;

@Service
@RequiredArgsConstructor
public class PatternConclusionServiceImpl implements PatternConclusionService {

    private final PatternConclusionRepository repository;
    private final PatternConclusionMapper mapper;

    @Override
    public PatternConclusion save(NewPatternConclusionDto conclusionDto) {
        return repository.save(mapper.mapToNewPatternConclusion(conclusionDto));
    }

    @Override
    public PatternConclusion update(UpdatePatternConclusionDto conclusionDto) {
        if (!repository.existsById(conclusionDto.getId())) {
           throw new NotFoundException(
                   String.format("conclusion with id=%s not found for update", conclusionDto.getId()));
        }
        return repository.save(mapper.mapToUpdatePatternConclusion(conclusionDto));
    }
}
