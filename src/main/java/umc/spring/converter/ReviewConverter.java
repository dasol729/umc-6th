package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.spring.web.dto.ReviewDTO.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static ReviewResponseDTO.JoinResultDTO toJoinResultDTO(Review review){
        return ReviewResponseDTO.JoinResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static Review toReview(ReviewRequestDTO.JoinDto request){

        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .build();
    }
}
