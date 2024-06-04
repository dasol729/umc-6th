package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.GeneralException;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MemberRepository memberRepository;

    private final MissionRepository missionRepository;

    private final MemberMissionRepository memberMissionRepository;

    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Mission joinMission(MissionRequestDTO.MissionJoinDto request, String storeId) {

        Mission newMission = MissionConverter.toMission(request);

        Store store = storeRepository.findById(Long.valueOf(storeId))
                .orElseThrow(() -> new GeneralException(ErrorStatus.STORE_NOT_FOUND));
        newMission.setStore(store);

        return missionRepository.save(newMission);
    }

    @Override
    public MemberMission progressMission(MissionRequestDTO.ProgressDto request, String missionId) {
        MemberMission newMission = MissionConverter.toMemberMission(request);

        Member member = memberRepository.findById(Long.valueOf(request.getMemberId()))
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));
        newMission.setMember(member);

        Mission mission = missionRepository.findById(Long.valueOf(missionId))
                .orElseThrow(() -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));
        newMission.setMission(mission);

        return memberMissionRepository.save(newMission);
    }
}
