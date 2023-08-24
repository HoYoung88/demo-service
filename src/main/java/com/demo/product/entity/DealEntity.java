package com.demo.product.entity;

import com.demo.common.entity.BaseEntity;
import jakarta.persistence.*;
import java.util.Collections;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

/**
 * Created by HoYoung on 2023/02/28.
 */
@Table(name = "deal")
@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@ToString
public class DealEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "product_id")
//    private long productId;

    @Column(name = "seller_id")
    private long sellerId;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private DealStatus status;

    @Column(name = "display_start_at")
    private LocalDateTime displayStartAt;

    @Column(name = "display_end_at")
    private LocalDateTime displayEndAt;

    @Column(name = "is_displaying")
    private boolean isDisplaying;

    @Column
    @OneToMany(mappedBy = "deal")
    @ToString.Exclude
    private List<DealOptionSelectEntity> dealOptions;

    public List<DealOptionSelectEntity> getDealOptions() {
        return Collections.unmodifiableList(this.dealOptions);
    }
}
