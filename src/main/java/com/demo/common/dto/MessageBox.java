package com.demo.common.dto;

import java.util.Collections;
import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by HoYoung on 2023/04/24.
 */
@Getter
@Builder
@ToString
public class MessageBox {

    private final MessageBoxType type;
    private final Set<MessageBoxButton> buttons;

    private MessageBox(MessageBoxType type, Set<MessageBoxButton> buttons) {
        this.type = type;
        this.buttons = buttons;
    }

    public static MessageBox createAlert(MessageBoxButton... button) {
        return MessageBox.builder()
                .type(MessageBoxType.ALERT)
                .buttons(Set.of(button))
                .build();
    }

    public static MessageBox createConfirm(MessageBoxButton... button) {
        return MessageBox.builder()
                .type(MessageBoxType.CONFIRM)
                .buttons(Set.of(button))
                .build();
    }

    public static MessageBox createToast() {
        return MessageBox.builder()
                .type(MessageBoxType.TOAST)
                .buttons(Set.of(MessageBoxButton.createCheck()))
                .build();
    }

    public static MessageBoxBuilder builder() {
        return new CustomMessageBoxBuilder();
    }

    public Set<MessageBoxButton> getButtons() {
        return Collections.unmodifiableSet(buttons);
    }

    private static class CustomMessageBoxBuilder extends MessageBoxBuilder {

        public MessageBox build() {
//            if(!MessageBoxType.TOAST.equals(super.type)) {
//                int buttonSize = super.buttons.size();
//
//                if(buttonSize < 2) {
//                    throw new RuntimeException("");
//                }
//            }

            return super.build();
        }
    }

}
