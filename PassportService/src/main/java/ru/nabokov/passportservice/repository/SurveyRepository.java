package ru.nabokov.passportservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.passportservice.model.passport.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
