package ru.nabokov.docservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.docservice.model.License;

public interface LicenseRepository extends JpaRepository<License, Long> {
}
