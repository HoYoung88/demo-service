package com.demo.common.error;

/**
 * Created by HoYoung on 2023/03/07.
 */
public interface ErrorCode {
    String name();
    default String getMessageKey() {
        return this.getClass().getPackageName().concat(".").concat(this.name().toLowerCase());
    }

}
