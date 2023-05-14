package ru.nabokov.docservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.docservice.model.ColumnsHeaders;

public interface ColumnsHeadersRepository extends JpaRepository<ColumnsHeaders, Long> {
}
