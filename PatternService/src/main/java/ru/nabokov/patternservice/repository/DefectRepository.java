package ru.nabokov.patternservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.patternservice.model.Defect;

public interface DefectRepository extends JpaRepository<Defect, Long> {
}
