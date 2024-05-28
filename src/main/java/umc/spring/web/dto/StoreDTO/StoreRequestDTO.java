package umc.spring.web.dto.StoreDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.spring.domain.Region;
import umc.spring.validation.annotation.ExistCategories;

import java.util.List;

public class StoreRequestDTO {
    @Getter
    public static class storeDto {
        @NotBlank
        String name;
        @NotNull
        String type;
        @Size(min = 5, max = 12)
        String address;
        String business_hour;
        String region;
        String description;
    }
}
