package ru.nabokov.patternservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.patternservice.model.HardnessProtocolPattern;

public interface HardnessProtocolPatternRepository extends JpaRepository<HardnessProtocolPattern, Long> {
}
