package com.demo.order.entity;

import static lombok.AccessLevel.PROTECTED;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by HoYoung on 2023/05/10.
 */
@Table(name = "orderItems")
@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    @Column
    private int quantity;

    @Column
    private int price;

    @Builder
    public OrderItem(int quantity, int price) {
        this.quantity = quantity;
        this.price = price;
    }

    public void addOrder(Orders order) {
        this.order = order;
    }

    public BigDecimal calculateSubtotal() {
        return BigDecimal.valueOf(this.price).multiply(BigDecimal.valueOf(this.quantity));
    }

}
