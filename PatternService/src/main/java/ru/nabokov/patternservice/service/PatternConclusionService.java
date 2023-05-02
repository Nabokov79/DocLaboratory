package ru.nabokov.patternservice.service;

import ru.nabokov.patternservice.model.PatternConclusion;

public interface PatternConclusionService {

    PatternConclusion save(PatternConclusion conclusion);

    PatternConclusion update(PatternConclusion conclusion);
}
