package br.com.promogames.promogames.controller.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record OfferRequest(
        BigDecimal originalPrice,
        BigDecimal currentPrice,
        LocalDateTime startsAt,
        LocalDateTime endsAt,
        UUID gameId
) {
}
