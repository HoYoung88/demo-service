package com.demo.order.controller;

import com.demo.common.dto.ApiResultResponse;
import com.demo.common.helper.ControllerHelper;
import com.demo.common.utils.UniqueRandomNumberGenerator;
import com.demo.order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HoYoung on 2023/03/07.
 */
@RestController
@RequestMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "주문")
@Slf4j
public class OrderController extends ControllerHelper {

    private final OrderService orderService;

    @GetMapping
    @Operation(summary = "주문 정보 조회")
    public ResponseEntity<?> getOrders() {
        this.orderService.order();
        return super.responseBody("");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/order-sheet/{orderSheetId}")
    @Operation(summary = "주문서 정보 조회",
            parameters = {
                    @Parameter(name = "orderSheetId", description = "주문서 아이디")
            }
    )
    public ResponseEntity<ApiResultResponse<String>> getOrderSheet(
            @PathVariable("orderSheetId") String orderSheetId) {
        UniqueRandomNumberGenerator uniqueRandomNumberGenerator = new UniqueRandomNumberGenerator();
        return super.responseBody(uniqueRandomNumberGenerator.generateOrderNumber());
    }

}