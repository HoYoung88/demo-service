package com.demo.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by HoYoung on 2023/04/24.
 */
@Getter
@AllArgsConstructor
public enum MessageBoxTextId {
    CHECK("com.demo.ui.messagebox.button.text.check"),
    PREVIOUS("com.demo.ui.messagebox.button.text.previous"),
    HOME("com.demo.ui.messagebox.button.text.home"),
    ;
    public final String textId;

}
