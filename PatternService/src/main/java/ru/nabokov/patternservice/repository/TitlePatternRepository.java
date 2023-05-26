package ru.nabokov.patternservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.patternservice.model.TitlePattern;

public interface TitlePatternRepository extends JpaRepository<TitlePattern, Long> {

    boolean existsByTypeId(Long typeId);
}
