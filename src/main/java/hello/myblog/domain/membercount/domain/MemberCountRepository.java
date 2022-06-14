package hello.myblog.domain.membercount.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberCountRepository extends JpaRepository<MemberCount, Long> {

}
