package ru.nabokov.docservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.docservice.model.Repair;

public interface RepairsRepository extends JpaRepository<Repair, Long> {
}
