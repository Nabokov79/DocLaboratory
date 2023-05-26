package ru.nabokov.patternservice.service.protocol;

import ru.nabokov.patternservice.dto.conclusion.NewPatternConclusionDto;
import ru.nabokov.patternservice.dto.conclusion.UpdatePatternConclusionDto;
import ru.nabokov.patternservice.model.PatternConclusion;

public interface PatternConclusionService {

    PatternConclusion save(NewPatternConclusionDto conclusionDto);

    PatternConclusion update(UpdatePatternConclusionDto conclusion);
}
