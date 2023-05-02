package ru.nabokov.patternservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.patternservice.model.Pipeline;

public interface PipelineRepository extends JpaRepository<Pipeline, Long> {
}
