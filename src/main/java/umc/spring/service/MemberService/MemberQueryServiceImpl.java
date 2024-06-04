package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.ReviewRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;

    private final MemberMissionRepository memberMissionRepository;

    private final ReviewRepository reviewRepository;

    @Override
    public Page<MemberMission> getMissionList(Long MemberId, Integer page) {

        Member member = memberRepository.findById(MemberId).get();

        Page<MemberMission> MissionPage = memberMissionRepository.findAllByMember(member, PageRequest.of(page, 10));

        return MissionPage;
    }

    @Override
    public Page<Review> getReviewListByMember(Long MemberId, Integer page) {

        Member member = memberRepository.findById(MemberId).get();

        Page<Review> reviewPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));

        return reviewPage;

    }
}
