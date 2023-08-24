package com.demo.order.infra.payment.naverpay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.ObjectUtils;

/**
 * Created by HoYoung on 2023/05/15.
 */
@Getter
@Builder
@ToString
public class NaverPayResponse {
    private final String code;
    private final String message;
    @JsonProperty(value = "error_code")
    private final String errorCode;

    public boolean isSuccess() {
        return !ObjectUtils.isEmpty(code) && "Success".equals(code);
    }
}
