package com.demo.product.service;

import com.demo.product.dto.DealDetail;
import com.demo.product.dto.mapper.DealMapper;
import com.demo.product.entity.DealEntity;
import com.demo.product.repository.DealEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by HoYoung on 2023/02/28.
 */
@Service
@RequiredArgsConstructor
public class ProductService {
    private final DealEntityRepository dealEntityRepository;
    private final DealMapper dealMapper;

    public DealDetail findByDealId() {
        DealEntity dealEntity = this.dealEntityRepository.findById(304352L).get();

        return dealMapper.from(dealEntity);
    }
}
