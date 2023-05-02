package ru.nabokov.patternservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.patternservice.model.PatternTable;

public interface PatternTableRepository extends JpaRepository<PatternTable, Long> {
}
