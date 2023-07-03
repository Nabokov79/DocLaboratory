package ru.nabokov.passportservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.passportservice.model.passport.ObjectCharacteristics;

public interface ObjectCharacteristicsRepository extends JpaRepository<ObjectCharacteristics, Long> {
}
