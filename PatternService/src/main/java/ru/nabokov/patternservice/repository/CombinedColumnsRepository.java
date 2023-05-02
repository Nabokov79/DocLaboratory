package ru.nabokov.patternservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.patternservice.model.CombinedColumns;

public interface CombinedColumnsRepository extends JpaRepository<CombinedColumns, Long> {
}
