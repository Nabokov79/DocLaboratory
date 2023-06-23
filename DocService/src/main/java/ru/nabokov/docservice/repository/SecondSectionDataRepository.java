package ru.nabokov.docservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.docservice.model.Characteristic;

public interface SecondSectionDataRepository extends JpaRepository<Characteristic, Long> {
}
