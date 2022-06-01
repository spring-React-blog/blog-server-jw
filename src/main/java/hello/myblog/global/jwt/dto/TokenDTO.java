package hello.myblog.global.jwt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import hello.myblog.global.jwt.vo.AccessToken;
import hello.myblog.global.jwt.vo.RefreshToken;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TokenDTO {

    @JsonProperty("access_token")
    private AccessToken accessToken;

    @JsonProperty("refresh_token")
    private RefreshToken refreshToken;

    public static TokenDTO of(final AccessToken accessToken, final RefreshToken refreshToken) {
        return new TokenDTO(accessToken, refreshToken);
    }
}
