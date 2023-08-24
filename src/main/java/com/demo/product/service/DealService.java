package com.demo.product.service;

import com.demo.product.dto.DealDetail;
import com.demo.product.dto.mapper.DealMapper;
import com.demo.product.entity.DealEntity;
import com.demo.product.error.DealErrorCode;
import com.demo.product.exception.DealServiceException;
import com.demo.product.repository.DealEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by HoYoung on 2023/04/06.
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class DealService {
    private final DealEntityRepository dealEntityRepository;
    private final DealMapper dealMapper;

    public DealDetail getDealDetail(long dealId) {
        DealEntity dealEntity = this.dealEntityRepository.findById(dealId)
                .orElseThrow(() -> new DealServiceException(DealErrorCode.DEAL_NOT_FOUND));

        dealEntity.getDealOptions().forEach(item -> log.debug("{}", item));

        return dealMapper.from(dealEntity);
    }
}
