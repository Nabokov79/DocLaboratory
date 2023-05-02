package ru.nabokov.patternservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.patternservice.model.Subheading;

public interface SubheadingRepository extends JpaRepository<Subheading, Long> {
}
