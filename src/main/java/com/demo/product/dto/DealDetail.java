package com.demo.product.dto;

import com.demo.product.entity.DealStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by HoYoung on 2023/02/28.
 */
@Builder
@Getter
@ToString
public class DealDetail {
    private String name;
    private DealStatus status;
    private long displayStartAt;
    private long displayEndAt;
}
