package com.demo.product.exception;

import com.demo.common.exception.DemoServiceException;
import com.demo.product.error.ProductErrorCode;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by HoYoung on 2023/03/07.
 */
@Getter
@Builder
@ToString
public class ProductServiceException extends DemoServiceException {
    private final ProductErrorCode errorCode;

    private ProductServiceException(ProductErrorCode productErrorCode) {
        super(productErrorCode);
        this.errorCode = productErrorCode;
    }
}
