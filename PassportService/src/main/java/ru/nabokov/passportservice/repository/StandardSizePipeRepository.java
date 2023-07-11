package ru.nabokov.passportservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.passportservice.model.StandardSizePipe;

public interface StandardSizePipeRepository extends JpaRepository<StandardSizePipe, Long> {
}
