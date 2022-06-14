package hello.myblog.domain.member.domain;

import hello.myblog.domain.board.domain.Board;
import hello.myblog.domain.membercount.domain.MemberCount;
import hello.myblog.domain.tempboard.domain.TempBoard;
import hello.myblog.global.common.BaseEntity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;

@Entity
@Getter
public class Member extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;

	private String email;

	@Embedded
	private Password password;
	private String name;
	private String nickname;
	private LocalDateTime birth;
	private LocalDateTime deleteTime;

	@Enumerated(EnumType.STRING)
	private RoleType role;

	@OneToOne
	private MemberCount memberCount;

	@OneToMany(mappedBy = "member")
	private List<Board> boards = new ArrayList<>();

	@OneToMany(mappedBy = "member")
	private List<TempBoard> tempBoards = new ArrayList<>();

}
