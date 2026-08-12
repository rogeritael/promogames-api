package br.com.promogames.promogames.repository;

import br.com.promogames.promogames.entity.Offer;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime;
import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    @Query(value = """
            SELECT o.*
            FROM offer o
            JOIN game g ON g.id = o.game_id
            JOIN store s ON s.id = g.store_id
            WHERE (:title IS NULL
                   OR LOWER(g.title) LIKE LOWER(CONCAT('%', :title, '%')))

              AND (:store IS NULL
                   OR LOWER(s.name) = LOWER(:store))

              AND (:platform IS NULL
                   OR EXISTS (
                       SELECT 1
                       FROM unnest(g.platforms) p
                       WHERE LOWER(p) = LOWER(:platform)
                   ))
            """,
            nativeQuery = true)
    List<Offer> search(
            @Param("title") String title,
            @Param("store") String store,
            @Param("platform") String platform
    );

    @Query("""
        SELECT o FROM Offer o
        WHERE o.endsAt >= :currentDate
    """)
    Page<Offer> findActive(
            @Param("currentDate") LocalDateTime currentDate,
            Pageable pageable
    );
}
