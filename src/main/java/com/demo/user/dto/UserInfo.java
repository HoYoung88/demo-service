package com.demo.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by HoYoung on 2023/04/07.
 */
@Builder
@Getter
@ToString
public class UserInfo {
    private final String email;
    private final String password;
    private final String nickname;
}
