package ru.nabokov.patternservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.patternservice.model.Recommendation;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
}
