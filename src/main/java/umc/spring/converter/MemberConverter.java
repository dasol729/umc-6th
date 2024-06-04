package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberDTO.MemberRequestDTO;
import umc.spring.web.dto.MemberDTO.MemberResponseDTO;
import umc.spring.web.dto.MissionDTO.MissionResponseDTO;
import umc.spring.web.dto.ReviewDTO.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static Member toMember(MemberRequestDTO.MemberJoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .email(request.getEmail())
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static MissionResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission){
        return MissionResponseDTO.MissionPreViewDTO.builder()
                .id(mission.getId())
                .deadline(mission.getDeadline())
                .reward(mission.getReward())
                .missionSpec(mission.getMissionSpec())
                .build();
    }
    public static MissionResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<Mission> missionList){
        List<MissionResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }

    public static MissionResponseDTO.MemberMissionPreViewDTO memberMissionPreViewDTO(MemberMission mission){
        return MissionResponseDTO.MemberMissionPreViewDTO.builder()
                .id(mission.getId())
                .memberId(mission.getMember().getId())
                .missionId(mission.getMission().getId())
                .create_at(mission.getCreatedAt())
                .status(String.valueOf(mission.getStatus()))
                .build();
    }
    public static MissionResponseDTO.MemberMissionPreViewListDTO memberMissionPreViewListDTO(Page<MemberMission> missionList){
        List<MissionResponseDTO.MemberMissionPreViewDTO> memberMissionPreViewDTOList = missionList.stream()
                .map(MemberConverter::memberMissionPreViewDTO).collect(Collectors.toList());

        return MissionResponseDTO.MemberMissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(memberMissionPreViewDTOList.size())
                .missionList(memberMissionPreViewDTOList)
                .build();
    }

}
