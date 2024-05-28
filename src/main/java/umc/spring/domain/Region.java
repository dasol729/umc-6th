package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.mapping.MemberMission;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String name;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<Store> storeList = new ArrayList<>();

    public Region(long id, Object name) {
    }
}
