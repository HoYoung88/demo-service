package com.demo.order.entity;

import static lombok.AccessLevel.PROTECTED;

import com.demo.common.utils.UniqueRandomNumberGenerator;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by HoYoung on 2023/05/09.
 */
@Table(name = "orders")
@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Orders {

    @Id
    @Column(length = 20)
    private String orderId;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(nullable = false, updatable = false)
    private LocalDateTime orderDate;

    @Column
    private int totalPrice;

    @Column
    private int totalOrderPrice;

    @Column
    private int totalOptionPrice;

    @Column
    private int shippingPrice;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> orderItems;

    @Builder
    public Orders(String orderId, OrderStatus orderStatus, int shippingPrice, LocalDateTime orderDate) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.shippingPrice = shippingPrice;
        this.orderDate = orderDate;
        this.orderItems = new HashSet<>();
    }

    public Set<OrderItem> getOrderItems() {
        return Collections.unmodifiableSet(orderItems);
    }

    public void addOrderItem(OrderItem orderItem) {
        this.orderItems.add(orderItem);
        orderItem.addOrder(this);
    }

    public void removeOrderItem(OrderItem orderItem) {
        orderItems.remove(orderItem);
        orderItem.addOrder(null);
    }

    public BigDecimal calculateTotalPrice() {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (OrderItem orderItem : orderItems) {
            totalPrice = totalPrice.add(orderItem.calculateSubtotal());
        }

        totalPrice = totalPrice.add(BigDecimal.valueOf(this.shippingPrice));

        return totalPrice;
    }

    @PrePersist
    private void prePersist() {
        UniqueRandomNumberGenerator uniqueRandomNumberGenerator = new UniqueRandomNumberGenerator();
        this.orderId = uniqueRandomNumberGenerator.generateOrderNumber();
    }

}
