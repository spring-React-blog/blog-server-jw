package hello.myblog.domain.member.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import hello.myblog.global.error.exception.ErrorCode;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Password {

	@NotBlank(message = "필수 값입니다.")
	private String password;

	public static Password from(final String password) {
		return new Password(password);
	}

	public static Password encode(final String rawPassword, final PasswordEncoder encoder) {
		validatePassword(rawPassword);
		return new Password(encoder.encode(rawPassword));
	}

	private static void validatePassword(final String rawPassword) {
		if (Objects.isNull(rawPassword) || rawPassword.isBlank()) {
			throw new PasswordNullException(ErrorCode.PASSWORD_NULL_ERROR);
		}
	}

	@JsonValue
	public String password() {
		return password;
	}

}
