package com.demo.order.error;

import com.demo.common.error.ErrorCode;

/**
 * Created by HoYoung on 2023/05/15.
 */
public enum PaymentErrorCode implements ErrorCode {
    PAYMENT_ERROR,
    PAYMENT_USER_CANCEL,
    PAYMENT_TIME_EXPIRED
}
