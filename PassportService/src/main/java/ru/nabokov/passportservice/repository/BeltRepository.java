package ru.nabokov.passportservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.passportservice.model.passport.Belt;
import java.util.List;

public interface BeltRepository extends JpaRepository<Belt, Long> {

    List<Belt> findAllByNumber(Integer number);
}
