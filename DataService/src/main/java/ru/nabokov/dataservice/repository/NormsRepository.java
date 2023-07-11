package ru.nabokov.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.dataservice.model.Norm;

public interface NormsRepository extends JpaRepository<Norm, Long> {
}