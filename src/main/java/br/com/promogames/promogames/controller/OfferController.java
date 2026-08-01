package br.com.promogames.promogames.controller;

import br.com.promogames.promogames.controller.request.OfferRequest;
import br.com.promogames.promogames.controller.response.OfferResponse;
import br.com.promogames.promogames.entity.Offer;
import br.com.promogames.promogames.mapper.OfferMapper;
import br.com.promogames.promogames.service.OfferService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/offer")
public class OfferController {
    private final OfferService offerService;

    @GetMapping()
    public ResponseEntity<List<OfferResponse>> findAll(){
        List<OfferResponse> mountedOffer = offerService.findAll().stream().map(OfferMapper::toOfferResponse).toList();

        return ResponseEntity.ok(mountedOffer);
    }

    @PostMapping()
    public ResponseEntity<OfferResponse> save(@RequestBody OfferRequest request){
        Offer savedOffer = offerService.save(OfferMapper.ToOffer(request), request.gameId());

        return ResponseEntity.status(HttpStatus.CREATED).body(OfferMapper.toOfferResponse(savedOffer));
    }

}
