package umc.spring.service.MissionService;

import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;

public interface MissionCommandService {
    Mission joinMission(MissionRequestDTO.JoinDto request, String storeId);

    MemberMission progressMission(MissionRequestDTO.ProgressDto request, String missionId);
}
