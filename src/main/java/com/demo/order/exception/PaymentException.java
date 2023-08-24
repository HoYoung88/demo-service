package com.demo.order.exception;

import com.demo.common.exception.DemoServiceException;
import com.demo.order.error.PaymentErrorCode;

/**
 * Created by HoYoung on 2023/05/15.
 */
public class PaymentException extends DemoServiceException {

    public PaymentException() {
        super(PaymentErrorCode.PAYMENT_ERROR);
    }

    public PaymentException(PaymentErrorCode paymentErrorCode) {
        super(paymentErrorCode);
    }
}
