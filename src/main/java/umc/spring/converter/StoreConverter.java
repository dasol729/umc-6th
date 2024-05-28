package umc.spring.converter;

import umc.spring.domain.Store;
import umc.spring.web.dto.StoreDTO.StoreRequestDTO;
import umc.spring.web.dto.StoreDTO.StoreResponseDTO;

public class StoreConverter {
    public static StoreResponseDTO.JoinResultDTO toJoinResultDTO(Store store){
        return StoreResponseDTO.JoinResultDTO.builder()
                .storeId(store.getId())
                .build();
    }
    public static Store toStore(StoreRequestDTO.storeDto request){

        return Store.builder()
                .name(request.getName())
                .type(request.getType())
                .address(request.getAddress())
                .business_hour(request.getBusiness_hour())
                .region(Long.parseLong(request.getRegion()))
                .description(request.getDescription())
                .build();
    }
}
