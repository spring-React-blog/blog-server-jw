package hello.myblog.domain.boardcount.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BoardCount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "board_count_id")
	private Long id;

	private Long viewCount;
	private int likeCount;
	private int replyCount;
}
