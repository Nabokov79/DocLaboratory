package ru.nabokov.patternservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.patternservice.model.UltrasonicProtocolPattern;

public interface UltrasonicProtocolPatternRepository extends JpaRepository<UltrasonicProtocolPattern, Long> {
}
