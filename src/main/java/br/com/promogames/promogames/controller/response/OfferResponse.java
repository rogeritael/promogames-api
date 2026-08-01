package br.com.promogames.promogames.controller.response;

import br.com.promogames.promogames.entity.Game;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record OfferResponse(
        Long id,
        BigDecimal originalPrice,
        BigDecimal currentPrice,
        LocalDateTime startsAt,
        LocalDateTime endsAt,
        Game game
) {
}
