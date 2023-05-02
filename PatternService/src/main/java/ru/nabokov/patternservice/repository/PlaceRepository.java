package ru.nabokov.patternservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.patternservice.model.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
