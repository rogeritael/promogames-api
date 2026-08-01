package br.com.promogames.promogames.mapper;

import br.com.promogames.promogames.controller.request.OfferRequest;
import br.com.promogames.promogames.controller.response.OfferResponse;
import br.com.promogames.promogames.entity.Offer;
import lombok.experimental.UtilityClass;

@UtilityClass
public class OfferMapper {
    public static Offer ToOffer(OfferRequest request){
        return Offer.builder()
                .originalPrice(request.originalPrice())
                .currentPrice(request.currentPrice())
                .startsAt(request.startsAt())
                .endsAt(request.endsAt())
                .build();
    }

    public static OfferResponse toOfferResponse(Offer offer){
        return OfferResponse.builder()
                .currentPrice(offer.getCurrentPrice())
                .game(offer.getGame())
                .originalPrice(offer.getOriginalPrice())
                .id(offer.getId())
                .startsAt(offer.getStartsAt())
                .endsAt(offer.getEndsAt())
                .build();
    }
}
