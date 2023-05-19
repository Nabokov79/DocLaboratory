package ru.nabokov.docservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.docservice.model.title.Title;

public interface TitleRepository extends JpaRepository<Title, Long> {
}
