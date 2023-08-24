package com.demo.user.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

/**
 * Created by HoYoung on 2023/05/09.
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@RedisHash(value = "refreshToken")
public class UserRefreshToken {
    @Id
    private String userId;
    private String refreshToken;

    @TimeToLive
    private long expiredTime;
}
