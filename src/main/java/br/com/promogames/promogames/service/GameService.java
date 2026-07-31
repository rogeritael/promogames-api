package br.com.promogames.promogames.service;

import br.com.promogames.promogames.entity.Game;
import br.com.promogames.promogames.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    public List<Game> findAll(){
        return gameRepository.findAll();
    }

    public Game save(Game game){
        return gameRepository.save(game);
    }

    public Optional<Game> findById(UUID id){
        return gameRepository.findById(id);
    }
}
