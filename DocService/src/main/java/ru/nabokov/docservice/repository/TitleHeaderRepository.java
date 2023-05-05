package ru.nabokov.docservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.docservice.model.TitleHeader;

public interface TitleHeaderRepository extends JpaRepository<TitleHeader, Long> {
}
