package com.demo.user.exception;

import com.demo.common.error.ErrorCode;
import com.demo.common.exception.DemoServiceException;
import com.demo.user.error.UserErrorCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * Created by HoYoung on 2023/03/07.
 */
@Getter
@ToString
public class UserServiceException extends DemoServiceException {

    public UserServiceException(UserErrorCode userErrorCode) {
        super(userErrorCode);
    }

    public UserServiceException(HttpStatus httpStatus, UserErrorCode userErrorCode) {
        super(httpStatus, userErrorCode);
    }

    public static class UserNotFound extends UserServiceException {
        public UserNotFound() {
            super(HttpStatus.NOT_FOUND, UserErrorCode.USER_NOT_FOUND);
        }
    }
}
