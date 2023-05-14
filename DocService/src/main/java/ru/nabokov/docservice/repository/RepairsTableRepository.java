package ru.nabokov.docservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.docservice.model.RepairsTable;

public interface RepairsTableRepository extends JpaRepository<RepairsTable, Long> {
}
