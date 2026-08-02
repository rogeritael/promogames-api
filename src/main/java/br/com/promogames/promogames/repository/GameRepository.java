package br.com.promogames.promogames.repository;

import br.com.promogames.promogames.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface GameRepository extends JpaRepository<Game, UUID> {
    @Query(value = """
        SELECT g.*
        FROM game g
        JOIN store s ON s.id = g.store_id
        WHERE (:title IS NULL
               OR g.title ILIKE CONCAT('%', :title, '%'))

          AND (:store IS NULL
               OR s.name ILIKE :store)

          AND (
               :platform IS NULL
               OR EXISTS (
                   SELECT 1
                   FROM unnest(g.platforms) AS platform_name
                   WHERE platform_name ILIKE :platform
               )
          )
        """,
            nativeQuery = true)
    List<Game> search(
            @Param("title") String title,
            @Param("store") String store,
            @Param("platform") String platform
    );
}
