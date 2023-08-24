package com.demo.product.exception;

import com.demo.common.error.ErrorCode;
import com.demo.common.exception.DemoServiceException;

/**
 * Created by HoYoung on 2023/04/06.
 */
public class DealServiceException extends DemoServiceException {

    public DealServiceException(ErrorCode errorCode) {
        super(errorCode);
    }

}
