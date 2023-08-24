package com.demo.common.exception;

import com.demo.common.dto.AdditionalAction;
import com.demo.common.error.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * Created by HoYoung on 2023/03/07.
 */
@Getter
public class DemoServiceException extends ResponseStatusException {
    private final ErrorCode errorCode;
    private final AdditionalAction additionalAction;

    public DemoServiceException(ErrorCode errorCode) {
        super(HttpStatus.BAD_REQUEST);
        this.errorCode = errorCode;
        this.additionalAction = null;
    }

    public DemoServiceException(ErrorCode errorCode, AdditionalAction additionalAction) {
        super(HttpStatus.BAD_REQUEST);
        this.errorCode = errorCode;
        this.additionalAction = additionalAction;
    }

    public DemoServiceException(HttpStatus httpStatus, ErrorCode errorCode) {
        super(httpStatus);
        this.errorCode = errorCode;
        this.additionalAction = null;
    }

    public DemoServiceException(HttpStatus httpStatus, ErrorCode errorCode, AdditionalAction additionalAction) {
        super(httpStatus);
        this.errorCode = errorCode;
        this.additionalAction = additionalAction;
    }

    public HttpStatus getHttpStatus() {
        return HttpStatus.resolve(super.getStatusCode().value());
    }

}
