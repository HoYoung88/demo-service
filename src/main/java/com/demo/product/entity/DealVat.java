package com.demo.product.entity;

import lombok.Getter;

/**
 * Created by HoYoung on 2023/02/28.
 */
public enum DealVat {
    TAXED("과세상품"),  // 과세
    FREE("면세상품"),   // 비과세
    SMALL("영세상품")   // 영세
    ;

    @Getter
    private final String name;
    DealVat(String name) {
        this.name = name;
    }
}
