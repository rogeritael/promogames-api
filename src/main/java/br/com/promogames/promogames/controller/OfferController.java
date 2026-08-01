package br.com.promogames.promogames.controller;

import br.com.promogames.promogames.controller.request.OfferRequest;
import br.com.promogames.promogames.controller.response.OfferResponse;
import br.com.promogames.promogames.entity.Offer;
import br.com.promogames.promogames.mapper.OfferMapper;
import br.com.promogames.promogames.repository.GameRepository;
import br.com.promogames.promogames.service.OfferService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/offer")
public class OfferController {
    private final OfferService offerService;
    private final GameRepository gameRepository;

    @GetMapping()
    public ResponseEntity<List<OfferResponse>> findAll(){
        List<OfferResponse> mountedOffer = offerService.findAll().stream().map(OfferMapper::toOfferResponse).toList();

        return ResponseEntity.ok(mountedOffer);
    }

    @GetMapping("/active")
    public ResponseEntity<List<OfferResponse>> findActive(){
        List<Offer> filteredOffer = offerService.findActive();

        return ResponseEntity.ok(filteredOffer.stream().map(offer -> OfferMapper.toOfferResponse(offer)).toList());
    }

    @PostMapping()
    public ResponseEntity<OfferResponse> save(@RequestBody OfferRequest request){
        Offer savedOffer = offerService.save(OfferMapper.ToOffer(request), request.gameId());

        return ResponseEntity.status(HttpStatus.CREATED).body(OfferMapper.toOfferResponse(savedOffer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Offer> findById(@PathVariable Long id){
        Optional<Offer> foundOffer = offerService.findById(id);

        return foundOffer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Optional<Offer> foundOffer = offerService.findById(id);

        if(foundOffer.isEmpty()){return ResponseEntity.notFound().build();}

        offerService.delete(foundOffer.get().getId());

        return ResponseEntity.noContent().build();
    }

}
