package br.com.promogames.promogames.service;

import br.com.promogames.promogames.controller.request.GameRequest;
import br.com.promogames.promogames.controller.response.GameResponse;
import br.com.promogames.promogames.entity.Game;
import br.com.promogames.promogames.entity.Store;
import br.com.promogames.promogames.repository.GameRepository;
import br.com.promogames.promogames.repository.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GameService {
    private final GameRepository gameRepository;
    private final StoreRepository storeRepository;

    public List<Game> findAll(){
        return gameRepository.findAll();
    }

    public Game save(Game game){
        return gameRepository.save(game);
    }

    public Optional<Game> findById(UUID id){
        return gameRepository.findById(id);
    }

    public void deleteById(UUID id){
        gameRepository.deleteById(id);
    }

    public Optional<Game> update(UUID id, GameRequest gameRequest){
        Optional<Game> foundGame = gameRepository.findById(id);

        if (foundGame.isEmpty()) {
            return Optional.empty();
        }

        Optional<Store> foundStore =
                storeRepository.findById(gameRequest.store());

        if (foundStore.isEmpty()) {
            return Optional.empty();
        }

        Game updatedGame = foundGame.get();

        updatedGame.setPlatforms(gameRequest.platforms());
        updatedGame.setImageUrl(gameRequest.imageUrl());
        updatedGame.setPlatforms(gameRequest.platforms());
        updatedGame.setStoreUrl(gameRequest.storeUrl());
        updatedGame.setTitle(gameRequest.title());
        updatedGame.setStore(foundStore.get());

        gameRepository.save(updatedGame);

        return Optional.of(updatedGame);
    }
}
