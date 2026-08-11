package br.com.promogames.promogames.service;

import br.com.promogames.promogames.entity.Game;
import br.com.promogames.promogames.entity.Offer;
import br.com.promogames.promogames.repository.GameRepository;
import br.com.promogames.promogames.repository.OfferRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OfferService {
    private final OfferRepository offerRepository;
    private final GameService gameService;
    private final GameRepository gameRepository;

    public List<Offer> findAll(){
        return offerRepository.findAll();
    }

    public List<Offer> findActive(){
        LocalDateTime currentDate = LocalDateTime.now();

        List<Offer> activeOffers = offerRepository.findAll().stream().filter(offer -> offer.getEndsAt().isEqual(currentDate) || offer.getEndsAt().isAfter(currentDate)).toList();

        return activeOffers;
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

    public Optional<Offer> findById(Long id){
        return offerRepository.findById(id);
    }

    public void delete(Long id){
        offerRepository.deleteById(id);
    }

    public List<Offer> search(String title, String store, String platform){
        return offerRepository.search(title, store, platform);
    }
}
