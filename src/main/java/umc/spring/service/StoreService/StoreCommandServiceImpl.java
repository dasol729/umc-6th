package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Store;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.StoreDTO.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Store joinStore(StoreRequestDTO.storeDto request) {

        Store newStore = StoreConverter.toStore(request);

        return storeRepository.save(newStore);
    }
}
