package br.com.promogames.promogames.repository;

import br.com.promogames.promogames.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GameRepository extends JpaRepository<Game, UUID> {
}
