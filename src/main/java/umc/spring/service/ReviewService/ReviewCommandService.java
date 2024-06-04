package umc.spring.service.ReviewService;

import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;

public interface ReviewCommandService {
    @Transactional
    Review joinReview(ReviewRequestDTO.ReviewJoinDto request, String restaurantId);
}
