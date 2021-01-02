package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//Spring이 자동으로 구현체를 만들어준다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // select m from Member m where m.name = ?
    // 인터페이스 이름만으로 자동으로 만들어줌. ex) findBynameAndId...
    @Override
    Optional<Member> findByName(String name);

    // 복잡한 쿼리는 QueryDsl이라는 라이브러리를 사용해서 사용한다.
    // 이 조합으로 해결하기 어려운 쿼리는 네이티브 쿼리를 사용하면 된다.
}
