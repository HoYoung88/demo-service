package com.demo.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by HoYoung on 2023/04/12.
 */
@Builder
@Getter
@ToString
public class AdditionalAction {
    @JsonInclude(Include.NON_EMPTY)
    private final MessageBox messageBox;

    public static AdditionalAction createMessageBox(MessageBox messageBox) {
        return AdditionalAction.builder()
                .messageBox(messageBox)
                .build();
    }

}
