package ru.nabokov.docservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.docservice.model.thirdSection.Survey;

public interface SurveysRepository extends JpaRepository<Survey, Long> {
}
