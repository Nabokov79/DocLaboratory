package ru.nabokov.patternservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.patternservice.model.ReportPattern;

public interface ReportPatternRepository extends JpaRepository<ReportPattern, Long> {
}