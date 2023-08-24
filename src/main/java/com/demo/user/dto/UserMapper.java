package com.demo.user.dto;

import com.demo.user.entity.UserDeviceEntity;
import com.demo.user.entity.UserEntity;
import org.mapstruct.Mapper;

/**
 * Created by HoYoung on 2023/04/06.
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserInfo toUserInfo(UserEntity userEntity);

    UserEntity toUserEntity(UserCreate userCreate);

    UserDeviceEntity toUserDeviceEntity(UserDeviceItem userDeviceItems);

}
