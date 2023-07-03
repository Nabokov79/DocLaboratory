package ru.nabokov.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.dataservice.model.Defect;

public interface DefectRepository extends JpaRepository<Defect, Long> {
}
