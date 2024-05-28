package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.spring.web.dto.ReviewDTO.ReviewResponseDTO;


@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/{storeId}")
    public ApiResponse<ReviewResponseDTO.JoinResultDTO> join(
            @RequestBody @Valid ReviewRequestDTO.JoinDto request,
            @PathVariable("storeId") @Valid String storeId){
        Review review = reviewCommandService.joinReview(request, storeId);
        return ApiResponse.onSuccess(ReviewConverter.toJoinResultDTO(review));
    }
}
