package com.demo.product.controller;

import com.demo.common.helper.ControllerHelper;
import com.demo.product.service.DealService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HoYoung on 2023/04/06.
 */
@RestController
@RequestMapping(value = "/deals", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "상품")
public class DealController extends ControllerHelper {
    private final DealService dealService;

    @GetMapping(value = "/{dealId}")
    public ResponseEntity<?> getDealDetail(@PathVariable long dealId) {
        return super.responseBody(this.dealService.getDealDetail(dealId));
    }


}
