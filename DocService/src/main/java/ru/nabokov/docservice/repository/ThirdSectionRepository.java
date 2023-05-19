package ru.nabokov.docservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.docservice.model.thirdSection.ThirdSection;

public interface ThirdSectionRepository extends JpaRepository<ThirdSection, Long> {
}
