package com.demo.product.entity;

import lombok.Getter;

/**
 * Created by HoYoung on 2023/02/28.
 */
public enum DealStatus {
    SAVE("저장"),       // 저장 상태
    SALE("판매중"),       // 판매중 상태
    STOP("판매중지"),       // 판매중지 상태
    FORBIDDEN("판매금지"),  // 판매금지 상태
    DELETE("삭제")      // 삭제 상태
    ;

    @Getter
    private final String name;

    DealStatus(String name) {
        this.name = name;
    }
}
