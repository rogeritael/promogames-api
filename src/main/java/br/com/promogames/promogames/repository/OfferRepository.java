package br.com.promogames.promogames.repository;

import br.com.promogames.promogames.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
