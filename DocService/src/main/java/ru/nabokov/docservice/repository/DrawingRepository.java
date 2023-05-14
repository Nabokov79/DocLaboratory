package ru.nabokov.docservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.docservice.model.Drawing;

public interface DrawingRepository extends JpaRepository<Drawing, Long> {
}
