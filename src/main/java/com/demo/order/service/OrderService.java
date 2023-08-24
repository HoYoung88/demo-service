package com.demo.order.service;

import com.demo.order.entity.OrderItem;
import com.demo.order.entity.OrderStatus;
import com.demo.order.entity.Orders;
import com.demo.order.repository.OrdersRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by HoYoung on 2023/05/10.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrdersRepository ordersRepository;

    @Transactional
    public void order() {
        Orders orders = Orders.builder()
                .orderStatus(OrderStatus.COMPLETE)
                .shippingPrice(3000)
                .orderDate(LocalDateTime.now())
                .build();

        orders.addOrderItem(OrderItem.builder()
                                    .price(1000)
                                    .quantity(2)
                                    .build());

        orders.addOrderItem(OrderItem.builder()
                                    .price(3000)
                                    .quantity(2)
                                    .build());

        log.debug("total {}", orders.calculateTotalPrice());
        ordersRepository.save(orders);
    }
}
