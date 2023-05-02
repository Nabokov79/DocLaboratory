package ru.nabokov.patternservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.patternservice.model.PatternConclusion;

public interface PatternConclusionRepository extends JpaRepository<PatternConclusion, Long> {
}
