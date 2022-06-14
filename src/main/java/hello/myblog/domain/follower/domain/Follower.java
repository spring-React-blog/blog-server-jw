package hello.myblog.domain.follower.domain;

import hello.myblog.domain.member.domain.Member;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class Follower {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "follower_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member fromMemberId;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member toMemberId;

}
