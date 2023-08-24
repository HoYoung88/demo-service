package com.demo.product.entity;

import com.demo.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import static lombok.AccessLevel.PROTECTED;

/**
 * Created by HoYoung on 2023/04/06.
 */
@Table(name = "deal_option_select")
@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@ToString
public class DealOptionSelectEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deal_id")
    @ToString.Exclude
    private DealEntity deal;

    private int stock;

    private long price;

    private String status;

    public void addDeal(DealEntity dealEntity) {
        this.deal = dealEntity;
    }

}
