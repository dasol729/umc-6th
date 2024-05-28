package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberDTO.MemberRequestDTO;
import umc.spring.web.dto.MemberDTO.MemberResponseDTO;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;
import umc.spring.web.dto.MissionDTO.MissionResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MissionConverter {
    public static MissionResponseDTO.JoinResultDTO toJoinResultDTO(Mission mission){
        return MissionResponseDTO.JoinResultDTO.builder()
                .missionId(mission.getId())
                .build();
    }
    public static Mission toMission(MissionRequestDTO.JoinDto request){
        return Mission.builder()
                .reward(request.getReward())
                .deadline(LocalDate.now())
                .missionSpec(request.getMissionSpec())
                .build();
    }

    public static MissionResponseDTO.ProgressResultDTO toProgressResultDTO(MemberMission mission){
        return MissionResponseDTO.ProgressResultDTO.builder()
                .memberMissionId(mission.getId())
                .build();
    }
    public static MemberMission toMemberMission(MissionRequestDTO.ProgressDto request){
        return MemberMission.builder()
                .build();
    }
}
