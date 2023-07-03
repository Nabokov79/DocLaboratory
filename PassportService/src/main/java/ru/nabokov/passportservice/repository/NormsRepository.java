package ru.nabokov.passportservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.passportservice.model.norms.TankNorm;

public interface NormsRepository extends JpaRepository<TankNorm, Long> {
}
