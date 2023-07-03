package ru.nabokov.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.dataservice.model.Element;

public interface ElementRepository extends JpaRepository<Element, Long> {
}