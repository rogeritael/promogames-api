package br.com.promogames.promogames.service;

import br.com.promogames.promogames.entity.Game;
import br.com.promogames.promogames.entity.Offer;
import br.com.promogames.promogames.repository.OfferRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OfferService {
    private final OfferRepository offerRepository;
    private final GameService gameService;

    public List<Offer> findAll(){
        return offerRepository.findAll();
    }

    public Offer save(Offer offer, UUID gameId){
        Game foundGame = gameService.findById(gameId).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Jogo não encontrado"
                )
        );;

        offer.setGame(foundGame);

        return offerRepository.save(offer);
    }
}
