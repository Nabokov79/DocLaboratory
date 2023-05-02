package ru.nabokov.patternservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.patternservice.model.TitlePageData;

public interface TitlePageDataRepository extends JpaRepository<TitlePageData, Long> {
}
