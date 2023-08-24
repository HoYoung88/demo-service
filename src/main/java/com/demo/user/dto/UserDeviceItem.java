package com.demo.user.dto;

import com.demo.user.entity.DevicePlatform;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by HoYoung on 2023/04/12.
 */
@Builder
@Getter
@ToString
public class UserDeviceItem {
    private final String deviceToken;
    private final DevicePlatform platform;

}
