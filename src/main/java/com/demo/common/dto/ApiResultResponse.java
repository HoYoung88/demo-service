package com.demo.common.dto;

import com.demo.common.error.ErrorCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by HoYoung on 2023/03/07.
 */
@Getter
@ToString
@AllArgsConstructor(staticName = "ofResponse")
public class ApiResultResponse<T> {

    private final String code;
    private final String message;
    @JsonInclude(Include.NON_EMPTY)
    private final T data;
    @JsonInclude(Include.NON_EMPTY)
    private final AdditionalAction additionalAction;

    public static <T> ApiResultResponse<T> ofResponse(T data) {
        return new ApiResultResponse<>("SUCCESS", "", data, null);
    }

    public static ApiResultResponse<Void> ofResponse(String code, String message) {
        return new ApiResultResponse<>(code, message, null, null);
    }

    public static ApiResultResponse<Void> ofResponse(ErrorCode errorCode, String message) {
        return ofResponse(errorCode.name(), message);
    }

    public static ApiResultResponse<Void> ofResponse(ErrorCode errorCode, String message, AdditionalAction additionalAction) {
        return new ApiResultResponse<>(errorCode.name(), message, null, additionalAction);
    }

}
