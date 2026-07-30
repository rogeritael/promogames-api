package br.com.promogames.promogames.controller.response;

import lombok.Builder;

@Builder
public record StoreResponse(Long id, String name) {
}
