package ru.nabokov.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.dataservice.model.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
