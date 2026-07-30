package br.com.promogames.promogames.service;

import br.com.promogames.promogames.entity.Store;
import br.com.promogames.promogames.repository.StoreRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public Store save(Store store){
        return storeRepository.save(store);
    }

    public List<Store> findAll(){
        return storeRepository.findAll();
    }

    public void delete(Long id){
        storeRepository.deleteById(id);
    }
}
