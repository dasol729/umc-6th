package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
