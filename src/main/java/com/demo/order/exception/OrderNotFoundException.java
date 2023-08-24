package com.demo.order.exception;

import com.demo.common.dto.AdditionalAction;
import com.demo.common.dto.MessageBox;
import com.demo.common.dto.MessageBoxButton;
import com.demo.common.exception.DemoServiceException;
import com.demo.order.error.OrderErrorCode;

/**
 * Created by HoYoung on 2023/05/15.
 */
public class OrderNotFoundException extends DemoServiceException {

    public OrderNotFoundException() {
        super(OrderErrorCode.ORDER_NOT_FOUND, AdditionalAction.createMessageBox(
                MessageBox.createAlert(MessageBoxButton.createPrevious())));
    }
}
