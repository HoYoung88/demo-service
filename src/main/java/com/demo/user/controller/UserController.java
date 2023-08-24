package com.demo.user.controller;

import com.demo.common.helper.ControllerHelper;
import com.demo.user.dto.UserCreate;
import com.demo.user.entity.UserRefreshToken;
import com.demo.user.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HoYoung on 2023/03/07.
 */
@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "유저")
public class UserController extends ControllerHelper {
    private final UserService userService;

    @GetMapping(value = "/me")
    public ResponseEntity<?> getUser(@RequestParam String email) {
        UserRefreshToken token = UserRefreshToken.builder()
                .userId("test")
                .refreshToken("test_token")
                .expiredTime(60)    //테스트용 1분
                .build();
        this.userService.saveRefreshToken(token);
        return super.responseBody(this.userService.getUser(email));
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postUser(@RequestBody @Validated UserCreate userCreate) {
        this.userService.createUser(userCreate);
        return super.responseBody("");
    }

}
