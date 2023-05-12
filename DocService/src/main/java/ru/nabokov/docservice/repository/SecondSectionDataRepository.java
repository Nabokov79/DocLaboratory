package ru.nabokov.docservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.docservice.model.SecondSectionData;

public interface SecondSectionDataRepository extends JpaRepository<SecondSectionData, Long> {
}
