package ru.nabokov.patternservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.patternservice.model.PipelineTable;

public interface PipelineTableRepository extends JpaRepository<PipelineTable, Long> {
}
