package com.demo.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by HoYoung on 2023/04/13.
 */
@Getter
@AllArgsConstructor
public enum ActionSchema {
    MAIN("/main", "demo://main"),
    BACK("BACK", "BACK"),
    ;

    private final String web;
    private final String mobile;

    public String getSchema(String platform) {
        if("ios".equals(platform) || "aos".equals(platform)) {
            return this.mobile;
        } else {
            return this.web;
        }
    }

}
