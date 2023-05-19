package ru.nabokov.docservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.docservice.model.thirdSection.SurveysTable;

public interface SurveysTableRepository extends JpaRepository<SurveysTable, Long> {
}
