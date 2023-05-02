package ru.nabokov.patternservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.patternservice.model.ColumnHeader;

public interface ColumnHeaderRepository extends JpaRepository<ColumnHeader, Long> {
}
