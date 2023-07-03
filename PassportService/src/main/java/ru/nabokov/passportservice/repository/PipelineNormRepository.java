package ru.nabokov.passportservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.passportservice.model.pipeline.PipelineNorm;

public interface PipelineNormRepository extends JpaRepository<PipelineNorm, Long> {
}
