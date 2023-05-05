package ru.nabokov.docservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.docservice.model.Title;

public interface TitleRepository extends JpaRepository<Title, Long> {
}
