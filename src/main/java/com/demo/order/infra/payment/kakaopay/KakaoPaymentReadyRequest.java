package com.demo.order.infra.payment.kakaopay;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by HoYoung on 2023/05/17.
 */
@Getter
@Builder
@ToString
public class KakaoPaymentReadyRequest {

    @feign.form.FormProperty("cid")
    private String cId;

    @feign.form.FormProperty("partner_order_id")
    private String orderId;

    @feign.form.FormProperty("partner_user_id")
    private String userId;

    @feign.form.FormProperty("item_name")
    private String productName;

    private int quantity;

    @feign.form.FormProperty("total_amount")
    private int totalAmount;

    @feign.form.FormProperty("tax_free_amount")
    private int taxFreeAmount;

    @feign.form.FormProperty("approval_url")
    private String approvalUrl;

    @feign.form.FormProperty("cancel_url")
    private String cancelUrl;

    @feign.form.FormProperty("fail_url")
    private String failUrl;

}
