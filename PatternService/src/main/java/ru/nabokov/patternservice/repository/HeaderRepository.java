package ru.nabokov.patternservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.patternservice.model.Header;

public interface HeaderRepository extends JpaRepository<Header, Long> {
}
