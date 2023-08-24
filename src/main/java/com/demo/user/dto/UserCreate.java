package com.demo.user.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by HoYoung on 2023/04/06.
 */
@Builder
@Getter
@ToString
public class UserCreate {
    private final String email;
    private final String password;
    private final String nickname;
    private final UserDeviceItem userDevice;
}
