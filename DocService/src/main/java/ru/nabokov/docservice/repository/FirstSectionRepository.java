package ru.nabokov.docservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.docservice.model.FirstSection;

public interface FirstSectionRepository extends JpaRepository<FirstSection, Long> {
}
