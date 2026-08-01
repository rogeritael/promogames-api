package br.com.promogames.promogames.controller.request;

import br.com.promogames.promogames.entity.Game;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OfferRequest(
        BigDecimal originalPrice,
        BigDecimal currentPrice,
        LocalDateTime startsAt,
        LocalDateTime endsAt,
        Game game
) {
}
