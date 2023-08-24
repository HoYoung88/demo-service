package com.demo.product.controller;

import com.demo.common.dto.ApiResultResponse;
import com.demo.common.helper.ControllerHelper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Created by HoYoung on 2023/02/28.
 */
@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "상품")
public class ProductController extends ControllerHelper {

    @GetMapping()
    public ResponseEntity<ApiResultResponse<Object>> getProduct() {
        return super.responseBody(Arrays.asList(1, 2, 3, 4, 5));
    }

    @PostMapping()
    public ResponseEntity<ApiResultResponse<Object>> postProduct() {
        return super.responseBody("");
    }

}
