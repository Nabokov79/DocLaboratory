package ru.nabokov.docservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.docservice.model.title.TextCentered;

public interface TextCenteredRepository extends JpaRepository<TextCentered, Long> {
}
