package ru.nabokov.patternservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.patternservice.model.VisualProtocolPattern;

public interface VisualProtocolPatternRepository extends JpaRepository<VisualProtocolPattern, Long> {
}