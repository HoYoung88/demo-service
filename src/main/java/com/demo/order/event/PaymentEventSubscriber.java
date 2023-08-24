package com.demo.order.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by HoYoung on 2023/05/15.
 */
@Component
@Slf4j
public class PaymentEventSubscriber {

    @EventListener
    public void handlePaymentFailEvent(PaymentFailEvent paymentFailEvent) {
        log.error("Payment Failed");
    }

    @EventListener
    public void handlePaymentSuccessEvent(PaymentSuccessEvent paymentSuccessEvent) {
        log.debug("Payment Succeeded");
    }

}
