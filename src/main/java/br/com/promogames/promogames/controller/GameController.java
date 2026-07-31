package br.com.promogames.promogames.controller;

import br.com.promogames.promogames.controller.request.GameRequest;
import br.com.promogames.promogames.controller.response.GameResponse;
import br.com.promogames.promogames.entity.Game;
import br.com.promogames.promogames.entity.Store;
import br.com.promogames.promogames.mapper.GameMapper;
import br.com.promogames.promogames.service.GameService;
import br.com.promogames.promogames.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/game")
public class GameController {
    private final GameService gameService;
    private final StoreService storeService;

    @PostMapping()
    public ResponseEntity<Game> save(@RequestBody GameRequest request){
        Optional<Store> foundStore = storeService.findById(request.store());

        if(foundStore.isPresent()){
            Game newGame = GameMapper.toGame(request, foundStore.get());
            Game createdGame = gameService.save(newGame);

            return ResponseEntity.status(HttpStatus.CREATED).body(createdGame);
        }

        return ResponseEntity.notFound().build();

    }

    @GetMapping()
    public ResponseEntity<List<GameResponse>> findAll(){
        List<GameResponse> games = gameService.findAll().stream().map(game -> GameMapper.toGameResponse(game)).toList();

        return ResponseEntity.ok(games);
    }
}
