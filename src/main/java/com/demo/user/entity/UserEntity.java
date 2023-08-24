package com.demo.user.entity;

import com.demo.common.entity.BaseEntity;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

import static lombok.AccessLevel.PROTECTED;

/**
 * Created by HoYoung on 2023/04/06.
 */
@Table(name = "users")
@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue
    @UuidGenerator
//    @ColumnDefault("random_uuid()")
    private UUID id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String nickname;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private final Set<UserDeviceEntity> userDevices = new HashSet<>();

    @Builder
    public UserEntity(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    public void addUserDevice(UserDeviceEntity userDeviceEntity) {
        userDevices.add(userDeviceEntity);
        userDeviceEntity.addUser(this);
    }

    public Set<UserDeviceEntity> getUserDevices() {
        return Collections.unmodifiableSet(userDevices);
    }
}
