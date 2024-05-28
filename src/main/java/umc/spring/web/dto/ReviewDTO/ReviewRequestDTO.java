package umc.spring.web.dto.ReviewDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.spring.validation.annotation.ExistCategories;

import java.util.List;

public class ReviewRequestDTO {
    @Getter
    public static class JoinDto{
        @NotNull
        Long memberId;
        @NotBlank
        String title;
        @NotNull
        float score;
    }
}
