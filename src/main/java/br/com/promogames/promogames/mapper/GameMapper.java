package br.com.promogames.promogames.mapper;

import br.com.promogames.promogames.controller.request.GameRequest;
import br.com.promogames.promogames.controller.response.GameResponse;
import br.com.promogames.promogames.entity.Game;
import br.com.promogames.promogames.entity.Store;
import lombok.experimental.UtilityClass;

import javax.swing.text.html.Option;
import java.util.Optional;

@UtilityClass
public class GameMapper {
    public static Game toGame(GameRequest request, Store store){
        return Game.builder()
                .store(store)
                .platforms(request.platforms())
                .imageUrl(request.imageUrl())
                .storeUrl(request.storeUrl())
                .title(request.title())
                .build();
    }

    public static GameResponse toGameResponse(Game game){

        return GameResponse.builder()
                .imageUrl(game.getImageUrl())
                .platforms(game.getPlatforms())
                .store(game.getStore())
                .storeUrl(game.getStoreUrl())
                .title(game.getTitle())
                .id(game.getId())
                .build();
    }
}
