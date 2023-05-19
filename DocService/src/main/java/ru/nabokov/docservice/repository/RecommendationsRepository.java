package ru.nabokov.docservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.nabokov.docservice.model.sixthSection.Recommendations;

import java.util.List;
import java.util.Set;

public interface RecommendationsRepository extends JpaRepository<Recommendations, Long> {

    @Query("select r from Recommendations r where r.recommendation in :recommendations")
    Set<Recommendations> findAllByRecommendation(@Param("recommendations")List<String> recommendations);
}
