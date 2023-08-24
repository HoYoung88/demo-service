package com.demo.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by HoYoung on 2023/03/07.
 */
public enum GlobalErrorCode implements ErrorCode {
    PAGE_NOT_FOUND,
    METHOD_NOT_SUPPORTED,
    MISSING_PATH_VARIABLE,
    MISSING_SERVLET_REQUEST_PARAMETER,
    INTERNAL_SERVER_ERROR
}
