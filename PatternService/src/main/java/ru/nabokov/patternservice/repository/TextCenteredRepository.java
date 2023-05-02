package ru.nabokov.patternservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.patternservice.model.TextCentered;

public interface TextCenteredRepository extends JpaRepository<TextCentered, Long> {
}
