package br.com.promogames.promogames.controller.response;

import br.com.promogames.promogames.entity.Store;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record GameResponse(
        UUID id,
        String title,
        String imageUrl,
        String storeUrl,
        String[] platforms,
        Store store
) {
}
