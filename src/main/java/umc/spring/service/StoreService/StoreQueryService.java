package umc.spring.service.StoreService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;

public interface StoreQueryService {
    Page<Review> getReviewList(Long StoreId, Integer page);
}
