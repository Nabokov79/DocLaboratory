package ru.nabokov.patternservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.patternservice.model.GeodesyProtocolPattern;

public interface GeodesyProtocolPatternRepository extends JpaRepository<GeodesyProtocolPattern, Long> {
}
