package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;
import umc.spring.web.dto.MissionDTO.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/{storeId}")
    public ApiResponse<MissionResponseDTO.JoinResultDTO> join(
            @RequestBody @Valid MissionRequestDTO.JoinDto request,
            @PathVariable("storeId") @Valid String storeId){
        Mission mission = missionCommandService.joinMission(request, storeId);
        return ApiResponse.onSuccess(MissionConverter.toJoinResultDTO(mission));
    }

    @PostMapping("/progress/{missionId}")
    public ApiResponse<MissionResponseDTO.ProgressResultDTO> progress(
            @RequestBody @Valid MissionRequestDTO.ProgressDto request,
            @PathVariable("missionId") @Valid String missionId){
        MemberMission mission = missionCommandService.progressMission(request, missionId);
        return ApiResponse.onSuccess(MissionConverter.toProgressResultDTO(mission));
    }
}
