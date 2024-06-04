package umc.spring.service.MemberService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;

public interface MemberQueryService {
    Page<MemberMission> getMissionList(Long MemberId, Integer page);

    Page<Review> getReviewListByMember(Long MemberId, Integer page);
}
