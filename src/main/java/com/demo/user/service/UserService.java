package com.demo.user.service;

import com.demo.user.dto.UserCreate;
import com.demo.user.dto.UserInfo;
import com.demo.user.dto.UserMapper;
import com.demo.user.entity.UserDeviceEntity;
import com.demo.user.entity.UserEntity;
import com.demo.user.entity.UserRefreshToken;
import com.demo.user.exception.UserServiceException;
import com.demo.user.repository.RefreshTokenRedisRepository;
import com.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by HoYoung on 2023/04/06.
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RefreshTokenRedisRepository refreshTokenRedisRepository;

    public UserInfo getUser(String email) {
        UserEntity userEntity = this.userRepository.findByEmail(email)
                .orElseThrow(UserServiceException.UserNotFound::new);
        return this.userMapper.toUserInfo(userEntity);
    }

    @Transactional
    public void createUser(UserCreate userCreate) {
        UserEntity userEntity = this.userMapper.toUserEntity(userCreate);
        UserDeviceEntity userDeviceEntity = this.userMapper.toUserDeviceEntity(userCreate.getUserDevice());
        userEntity.addUserDevice(userDeviceEntity);

        this.userRepository.save(userEntity);
    }

    public void saveRefreshToken(UserRefreshToken userRefreshToken) {
        this.refreshTokenRedisRepository.save(userRefreshToken);
    }
}
