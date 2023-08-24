package com.demo.order.exception.payment;

import com.demo.order.error.PaymentErrorCode;
import com.demo.order.exception.PaymentException;

/**
 * Created by HoYoung on 2023/05/15.
 */
public class PaymentUserCancelException extends PaymentException {

    public PaymentUserCancelException() {
        super(PaymentErrorCode.PAYMENT_USER_CANCEL);
    }
}
