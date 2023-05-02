package ru.nabokov.patternservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.patternservice.exceptions.BadRequestException;
import ru.nabokov.patternservice.exceptions.NotFoundException;
import ru.nabokov.patternservice.model.PatternConclusion;
import ru.nabokov.patternservice.repository.PatternConclusionRepository;

@Service
@RequiredArgsConstructor
public class PatternConclusionServiceImpl implements PatternConclusionService {

    private final PatternConclusionRepository repository;

    @Override
    public PatternConclusion save(PatternConclusion conclusion) {
        validate(conclusion);
        return repository.save(conclusion);
    }

    @Override
    public PatternConclusion update(PatternConclusion conclusion) {
        if (!repository.existsById(conclusion.getId())) {
           throw new NotFoundException(String.format("conclusion with id=%s not found for update", conclusion.getId()));
        }
        validate(conclusion);
        return repository.save(conclusion);
    }

    private void validate(PatternConclusion conclusion) {
        if (conclusion.getIsDefect() == null) {
            throw new BadRequestException("IsDefect cannot be empty");
        }
        if (conclusion.getIsNotDefect() == null) {
            throw new BadRequestException("IsNotDefect cannot be empty");
        }
    }
}
