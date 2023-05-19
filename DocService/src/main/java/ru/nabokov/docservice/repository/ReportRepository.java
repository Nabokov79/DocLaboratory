package ru.nabokov.docservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.docservice.model.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
