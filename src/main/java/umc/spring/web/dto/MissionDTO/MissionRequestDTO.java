package umc.spring.web.dto.MissionDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {
    @Getter
    public static class MissionJoinDto{
        @NotNull
        Integer reward;
        @NotNull
        String missionSpec;
    }

    @Getter
    public static class ProgressDto{
        @NotNull
        Integer memberId;
    }
}
