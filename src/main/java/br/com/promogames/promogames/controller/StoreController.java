package br.com.promogames.promogames.controller;

import br.com.promogames.promogames.controller.response.StoreResponse;
import br.com.promogames.promogames.entity.Store;
import br.com.promogames.promogames.mapper.StoreMapper;
import br.com.promogames.promogames.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @GetMapping()
    public ResponseEntity<List<StoreResponse>> findAll(){
        List<StoreResponse> stores = storeService.findAll().stream()
                .map(store -> StoreMapper.toStoreResponse(store))
                .toList();

        return ResponseEntity.ok(stores);
    }
}
