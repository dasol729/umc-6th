package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Store;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.web.dto.StoreDTO.StoreRequestDTO;
import umc.spring.web.dto.StoreDTO.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.JoinResultDTO> join(@RequestBody @Valid StoreRequestDTO.storeDto request){
        Store store = storeCommandService.joinStore(request);
        return ApiResponse.onSuccess(StoreConverter.toJoinResultDTO(store));
    }
}
