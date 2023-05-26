package ru.nabokov.patternservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.patternservice.model.Element;

public interface ElementRepository extends JpaRepository<Element, Long> {
}