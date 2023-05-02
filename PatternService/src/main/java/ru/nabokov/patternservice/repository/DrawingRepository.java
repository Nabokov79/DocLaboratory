package ru.nabokov.patternservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.patternservice.model.Drawing;

public interface DrawingRepository extends JpaRepository<Drawing, Long> {
}
