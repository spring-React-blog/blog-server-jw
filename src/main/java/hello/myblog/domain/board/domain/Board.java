package hello.myblog.domain.board.domain;

import hello.myblog.domain.boardcount.domain.BoardCount;
import hello.myblog.domain.category.domain.Category;
import hello.myblog.domain.like.domain.Like;
import hello.myblog.domain.member.domain.Member;
import hello.myblog.domain.reply.domain.Reply;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;

@Entity
@Getter
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "board_id")
	private Long id;

	private String title;
	private String content;
	private String boardImg;
	private Boolean openStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "memberId")
	private Member member;

	@ManyToOne
	@JoinColumn(name = "board_count_ID")
	private BoardCount boardCount;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@OneToMany
	private List<Like> likes = new ArrayList<>();

	@OneToMany(mappedBy = "member")
	private List<Reply> replies = new ArrayList<>();

}
