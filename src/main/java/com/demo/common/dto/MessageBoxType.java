package com.demo.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by HoYoung on 2023/04/24.
 */
@Getter
@ToString
@AllArgsConstructor
public enum MessageBoxType {
    ALERT, CONFIRM, TOAST

}
