package ru.nabokov.patternservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.patternservice.model.TitlePageData;

public interface TextCenteredRepository extends JpaRepository<TitlePageData, Long> {
}
