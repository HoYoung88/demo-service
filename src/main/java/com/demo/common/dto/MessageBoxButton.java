package com.demo.common.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by HoYoung on 2023/04/24.
 */
@Getter
@Builder
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageBoxButton {

    private final MessageBoxTextId textId;
    private final MessageBoxActionType action;

    public static MessageBoxButton createCheck() {
        return MessageBoxButton.builder()
                .textId(MessageBoxTextId.CHECK)
                .action(MessageBoxActionType.CHECK)
                .build();
    }

    public static MessageBoxButton createPrevious() {
        return MessageBoxButton.builder()
                .textId(MessageBoxTextId.PREVIOUS)
                .action(MessageBoxActionType.PREVIOUS)
                .build();
    }

    public static MessageBoxButton createHome() {
        return MessageBoxButton.builder()
                .textId(MessageBoxTextId.HOME)
                .action(MessageBoxActionType.HOME)
                .build();
    }

    public String getTextId() {
        return this.textId.getTextId();
    }
}
