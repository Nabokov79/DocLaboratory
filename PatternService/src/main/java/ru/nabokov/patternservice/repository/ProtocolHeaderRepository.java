package ru.nabokov.patternservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.patternservice.model.ProtocolHeader;

public interface ProtocolHeaderRepository extends JpaRepository<ProtocolHeader, Long> {
}
