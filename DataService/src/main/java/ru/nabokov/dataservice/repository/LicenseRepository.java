package ru.nabokov.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.dataservice.model.Licenses;
import java.time.LocalDate;

public interface LicenseRepository extends JpaRepository<Licenses, Long> {

    boolean existsByDate(LocalDate date);
}
