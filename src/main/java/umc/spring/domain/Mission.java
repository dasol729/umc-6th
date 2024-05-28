package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.mapping.MemberMission;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private Integer reward;

    @Column(nullable = false, length = 40)
    private LocalDate deadline;

    @Column(nullable = false, length = 40)
    private String missionSpec;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    public void setStore(Store store){
        if(this.store != null)
            store.getMissionList().remove(this);
        this.store = store;
        store.getMissionList().add(this);
    }

}
