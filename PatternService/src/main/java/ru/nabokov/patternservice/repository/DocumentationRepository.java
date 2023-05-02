package ru.nabokov.patternservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.patternservice.model.Documentation;

public interface DocumentationRepository extends JpaRepository<Documentation, Long> {
}