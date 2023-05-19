package ru.nabokov.docservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.docservice.model.sixthSection.SubheadingSection;

public interface SubheadingsRepository extends JpaRepository<SubheadingSection, Long> {
}
