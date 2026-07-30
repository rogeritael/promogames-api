package br.com.promogames.promogames.controller;

import br.com.promogames.promogames.controller.request.StoreRequest;
import br.com.promogames.promogames.controller.response.StoreResponse;
import br.com.promogames.promogames.entity.Store;
import br.com.promogames.promogames.mapper.StoreMapper;
import br.com.promogames.promogames.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @GetMapping()
    public ResponseEntity<List<StoreResponse>> findAll(){
        List<StoreResponse> stores = storeService.findAll().stream()
                .map(StoreMapper::toStoreResponse)
                .toList();

        return ResponseEntity.ok(stores);
    }

    @PostMapping()
    public ResponseEntity<StoreResponse> save(@RequestBody StoreRequest request){
        Store newStore = storeService.save(StoreMapper.toStore(request));

        StoreResponse response = StoreMapper.toStoreResponse(newStore);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
