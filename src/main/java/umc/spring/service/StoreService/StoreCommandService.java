package umc.spring.service.StoreService;

import umc.spring.domain.Store;
import umc.spring.web.dto.StoreDTO.StoreRequestDTO;
public interface StoreCommandService {
    Store joinStore(StoreRequestDTO.storeDto request);
}
