package br.com.promogames.promogames.controller.response;

import br.com.promogames.promogames.entity.Store;

import java.time.LocalDateTime;

public record GameResponse(
        String title,
        String imageUrl,
        String storeUrl,
        String[] platforms,
        Store store,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
