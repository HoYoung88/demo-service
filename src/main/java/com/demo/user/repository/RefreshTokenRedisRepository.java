package com.demo.user.repository;

import com.demo.user.entity.UserRefreshToken;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by HoYoung on 2023/05/09.
 */
public interface RefreshTokenRedisRepository extends CrudRepository<UserRefreshToken, String> {

}
