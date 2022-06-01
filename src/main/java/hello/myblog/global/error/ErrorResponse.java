package hello.myblog.global.error;

import hello.myblog.global.error.exception.ErrorCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {

    private String message;
    private int status;
    private String code;

    private ErrorResponse(final ErrorCode errorCode) {
        message = errorCode.getMessage();
        status = errorCode.getStatus();
        code = errorCode.getCode();
    }

    public static ErrorResponse of(final ErrorCode errorCode) {
        return new ErrorResponse(errorCode);
    }
}
