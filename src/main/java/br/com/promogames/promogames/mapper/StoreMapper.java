package br.com.promogames.promogames.mapper;

import br.com.promogames.promogames.controller.request.StoreRequest;
import br.com.promogames.promogames.controller.response.StoreResponse;
import br.com.promogames.promogames.entity.Store;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StoreMapper {
    public static Store toStore(StoreRequest request){
        return Store.builder()
                .name(request.name())
                .build();
    }

    public static StoreResponse toStoreResponse(Store store){
        return StoreResponse.builder()
                .id(store.getId())
                .name(store.getName())
                .build();
    }
}
