package hello.myblog.global.jwt.error;

import hello.myblog.global.error.exception.BusinessException;
import hello.myblog.global.error.exception.ErrorCode;

public class TokenNotFoundException extends BusinessException {
    public TokenNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
