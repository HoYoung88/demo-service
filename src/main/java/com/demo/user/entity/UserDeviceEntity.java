package com.demo.user.entity;

import static lombok.AccessLevel.PROTECTED;

import com.demo.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by HoYoung on 2023/04/12.
 */
@Table(name = "user_device")
@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class UserDeviceEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private String deviceToken;

    @Enumerated(EnumType.STRING)
    private DevicePlatform platform;

    @Builder
    public UserDeviceEntity(String deviceToken, DevicePlatform platform) {
        this.deviceToken = deviceToken;
        this.platform = platform;
    }

    public void addUser(UserEntity user) {
        this.user = user;
    }
}
