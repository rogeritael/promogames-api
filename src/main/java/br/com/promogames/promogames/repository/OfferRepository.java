package br.com.promogames.promogames.repository;

import br.com.promogames.promogames.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    @Query(value = """
        SELECT o.*
        FROM offer o
        JOIN game g ON g.id = o.game_id
        JOIN store s ON s.id = g.store_id
        WHERE (:title IS NULL
               OR LOWER(g.title) LIKE LOWER(CONCAT('%', :title, '%')))

          AND (:stores IS NULL
               OR LOWER(s.name) = ANY(:stores))

          AND (:platforms IS NULL
               OR EXISTS (
                   SELECT 1
                   FROM unnest(g.platforms) p
                   WHERE LOWER(p) = ANY(:platforms)
               ))
        """,
            nativeQuery = true)
    List<Offer> search(
            @Param("title") String title,
            @Param("stores") String[] stores,
            @Param("platforms") String[] platforms
    );
}
