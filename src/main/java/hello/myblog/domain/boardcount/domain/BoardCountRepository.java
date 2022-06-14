package hello.myblog.domain.boardcount.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardCountRepository extends JpaRepository<BoardCount, Long> {

}
