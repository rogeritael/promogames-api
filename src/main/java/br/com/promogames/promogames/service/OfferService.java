package br.com.promogames.promogames.service;

import br.com.promogames.promogames.entity.Offer;
import br.com.promogames.promogames.repository.OfferRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OfferService {
    private final OfferRepository offerRepository;

    public List<Offer> findAll(){
        return offerRepository.findAll();
    }

    public Offer save(Offer offer){
        return offerRepository.save(offer);
    }
}
