package ru.nabokov.docservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.docservice.model.thirdSection.Repair;

public interface RepairsRepository extends JpaRepository<Repair, Long> {
}
