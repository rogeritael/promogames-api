package br.com.promogames.promogames.controller.request;

import br.com.promogames.promogames.entity.Store;

import java.util.UUID;

public record GameRequest(
        String title,
        String imageUrl,
        String storeUrl,
        String[] platforms,
        Long store
) {
}
