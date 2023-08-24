package com.demo.order.infra.payment.kakaopay;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by HoYoung on 2023/05/17.
 */
@FeignClient(name = "KakaoPayClient",
        url = "${payment.kakao-pay.url}")
public interface KakaoPayClient {

    @PostMapping(value = "/v1/payment/ready",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    KakaoPaymentReadyResponse paymentReady(KakaoPaymentReadyRequest kakaoPaymentReadyRequest);

}



