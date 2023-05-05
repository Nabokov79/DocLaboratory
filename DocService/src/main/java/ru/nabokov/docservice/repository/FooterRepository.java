package ru.nabokov.docservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.docservice.model.Footer;

public interface FooterRepository extends JpaRepository<Footer, Long> {
}
