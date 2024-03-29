package dong.shop.domain.member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Member findById(Long id);
    List<Member> findAll();

    Optional<Member> findMemberByLoginId(String loginId);
}
