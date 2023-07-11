package ru.nabokov.passportservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.passportservice.model.Bottom;

import java.util.List;

public interface BottomRepository extends JpaRepository<Bottom, Long> {

    List<Bottom> findAllByName(String name);
}
