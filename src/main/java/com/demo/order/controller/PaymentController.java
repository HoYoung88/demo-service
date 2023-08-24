package com.demo.order.controller;

import com.demo.common.helper.ControllerHelper;
import com.demo.order.event.PaymentFailEvent;
import com.demo.order.event.PaymentSuccessEvent;
import com.demo.order.exception.PaymentException;
import com.demo.order.exception.payment.PaymentTimeExpiredException;
import com.demo.order.exception.payment.PaymentUserCancelException;
import com.demo.order.infra.payment.kakaopay.KakaoPayClient;
import com.demo.order.infra.payment.kakaopay.KakaoPaymentReadyRequest;
import com.demo.order.infra.payment.naverpay.NaverPayClient;
import com.demo.order.infra.payment.naverpay.NaverPayResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HoYoung on 2023/05/15.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/payment")
@Slf4j
public class PaymentController extends ControllerHelper {

    private final NaverPayClient naverPayClient;
    private final KakaoPayClient kakaoPayClient;
    private final ApplicationEventPublisher applicationEventPublisher;

    @GetMapping(value = "/{orderSheetId}/naver")
    public ResponseEntity<?> getPaymentNaver(@PathVariable("orderSheetId") String orderSheetId,
                                             @RequestParam("resultCode") String resultCode,
                                             @RequestParam(value = "paymentId", required = false, defaultValue = "") String naverPaymentId) {

        log.debug("orderSheetId : {}", orderSheetId);
        log.debug("resultCode : {}", resultCode);
        log.debug("naverPaymentId : {}", naverPaymentId);

        NaverPayResponse naverPayResponse = NaverPayResponse.builder().errorCode("024")
                .message("Not Exist Client ID : Authentication failed. (인증에 실패했습니다.)")
                .build();

//        this.naverPayClient.applyPayment("adwd");

        switch (resultCode) {
            case "Success" -> {
                if (!naverPayResponse.isSuccess()) {
                    this.applicationEventPublisher.publishEvent(new PaymentFailEvent());
                    throw new PaymentException();
                } else {
                    this.applicationEventPublisher.publishEvent(new PaymentSuccessEvent());
                }
                return super.responseBody("");
            }
            case "UserCancel" -> throw new PaymentUserCancelException();
            case "TimeExpired" -> throw new PaymentTimeExpiredException();
            default -> throw new PaymentException();
        }
    }

    @GetMapping(value = "/ready")
    public ResponseEntity<?> getPaymentReady() {
        KakaoPaymentReadyRequest kakaoPaymentReadyRequest = KakaoPaymentReadyRequest.builder()
                .cId("TC0ONETIME")
                .orderId("partner_order_id")
                .userId("partner_user_id")
                .productName("초코파이")
                .quantity(1)
                .totalAmount(2000)
                .approvalUrl("http://localhost:8080/success")
                .failUrl("http://localhost:8080/fail")
                .cancelUrl("http://localhost:8080/cancel")
                .build();

        return super.responseBody(this.kakaoPayClient.paymentReady(kakaoPaymentReadyRequest));
    }

    @PostMapping(value = "/apply-payment")
    public ResponseEntity<?> postApplyPayment() {

        return super.responseBody("");
    }
}
