package com.demo.order.infra.payment.naverpay;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by HoYoung on 2023/05/15.
 */
@FeignClient(name = "NaverPayClient", url = "${payment.naver-pay.url}")
public interface NaverPayClient {

    @PostMapping(value = "/{naverpayPartnerId}/naverpay/payments/v2.2/apply/payment",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    NaverPayResponse applyPayment(@PathVariable("naverpayPartnerId") String naverpayPartnerId,
                                  @RequestParam("paymentId") String naverPaymentId);

    @PostMapping(value = "/{naverpayPartnerId}/naverpay/payments/v1/cancel",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    NaverPayResponse cancelPayment(@PathVariable("naverpayPartnerId") String naverpayPartnerId,
                                   @RequestParam("paymentId") String naverPaymentId,
                                   @RequestParam("cancelAmount") long cancelAmount,
                                   @RequestParam("cancelReason") String cancelReason,
                                   @RequestParam("cancelRequester") int cancelRequester);
}
